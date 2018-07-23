package com.android.mivitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mivitest.model.CollectionData;
import com.android.mivitest.model.Details;
import com.android.mivitest.model.ProductAttributes;
import com.android.mivitest.model.SubscriptionAttributes;
import com.android.mivitest.model.UserAttributes;
import com.android.mivitest.model.UserData;
import com.android.mivitest.parser.ResponseJSONParser;
import com.android.mivitest.util.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ACTDetails extends AppCompatActivity {
    CollectionData collectionData;
    @BindView(R.id.tvAccountNumber)
    TextView tvAccountNumber;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvEmail)
    TextView tvEmail;

    @BindView(R.id.tvPhone)
    TextView tvPhone;

    @BindView(R.id.tvDataBalance)
    TextView tvDataBalance;

    @BindView(R.id.tvExpiryDate)
    TextView tvExpiryDate;

    @BindView(R.id.tvAutoRenewal)
    TextView tvAutoRenewal;

    @BindView(R.id.tvPlanName)
    TextView tvPlanName;

    @BindView(R.id.tvUnlimitedCalling)
    TextView tvUnlimitedCalling;

    @BindView(R.id.tvUnlimitedMessages)
    TextView tvUnlimitedMessages;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        collectionData = MIVIApplication.getAppInstance().getCollectionData();

        if (collectionData != null)
            updateDetails();
        else {
            collectionData = ResponseJSONParser.getParsedResponse(Utils.readFromCollectionJSON(getAssets()));
            Toast.makeText(this, "No data Available", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateDetails() {
        UserData userData = collectionData.getUserData();
        tvAccountNumber.setText(" : " + userData.getId());
        UserAttributes userAttributes = userData.getUserAttributes();
        tvName.setText(" : " + userAttributes.getTitle() + " " + userAttributes.getFirstName() + " " + userAttributes.getLastName());
        tvEmail.setText(" : " + userAttributes.getEmailId());
        tvPhone.setText(" : " + userAttributes.getContactNumber());

        ArrayList<Details> details = collectionData.getDetails();
        if (details != null && details.size() >= 0) {
            Details detailsSubscriptions = null;
            Details detailsServices = null;
            Details detailsProducts = null;
            for (int i = 0; i < details.size(); ++i) {
                Details d = details.get(i);

                if (d.getType().equals("subscriptions"))
                    detailsSubscriptions = d;
                else if (d.getType().equals("services"))
                    detailsServices = d;
                else if (d.getType().equals("products"))
                    detailsProducts = d;
            }

            if (detailsSubscriptions != null) {
                SubscriptionAttributes subscriptionAttributes = (SubscriptionAttributes) detailsSubscriptions.getAttributes();
                if (subscriptionAttributes != null) {
                    tvDataBalance.setText(" : " + subscriptionAttributes.getIncludedDataBalance() + " MB");
                    tvExpiryDate.setText(" : " + subscriptionAttributes.getExpiryDate());
                    if (subscriptionAttributes.isAutoRenewal())
                        tvAutoRenewal.setText(" : Yes");
                    else
                        tvAutoRenewal.setText(" : No");
                }
            }

            if (detailsProducts != null) {
                ProductAttributes productAttributes = (ProductAttributes) detailsProducts.getAttributes();
                if (productAttributes != null) {
                    tvPlanName.setText(" : " + productAttributes.getName());
                    if (productAttributes.isUnlimitedTalk())
                        tvUnlimitedCalling.setText(" : Yes");
                    else
                        tvUnlimitedCalling.setText(" : No");

                    if (productAttributes.isUnlimitedText())
                        tvUnlimitedMessages.setText(" : Yes");
                    else
                        tvUnlimitedMessages.setText(" : No");

                    tvPrice.setText(" : $ " + productAttributes.getPrice());
                }
            }
        }
    }
}
