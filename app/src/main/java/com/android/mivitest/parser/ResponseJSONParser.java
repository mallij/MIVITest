package com.android.mivitest.parser;

import com.android.mivitest.model.Attributes;
import com.android.mivitest.model.CollectionData;
import com.android.mivitest.model.Details;
import com.android.mivitest.model.ProductAttributes;
import com.android.mivitest.model.ServiceAttributes;
import com.android.mivitest.model.SubscriptionAttributes;
import com.android.mivitest.model.UserAttributes;
import com.android.mivitest.model.UserData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ResponseJSONParser {
    public static CollectionData getParsedResponse(String json) {
        CollectionData collectionData = null;
        if (json != null && json.length() > 0) {
            collectionData = new CollectionData();
            try {
                JSONObject objectParent = new JSONObject(json);
                if (objectParent != null) {
                    JSONObject objectData = objectParent.optJSONObject("data");
                    if (objectData != null) {
                        UserData userData = new UserData();
                        userData.setId(objectData.optString("id"));
                        userData.setType(objectData.optString("accounts"));
                        JSONObject objAttributes = objectData.optJSONObject("attributes");
                        if (objAttributes != null) {
                            UserAttributes userAttributes = new UserAttributes();
                            userAttributes.setPaymentType(objAttributes.optString("payment-type"));
                            userAttributes.setUnbilledCharges(objAttributes.optString("unbilled-charges"));
                            userAttributes.setNextBillingDate(objAttributes.optString("next-billing-date"));
                            userAttributes.setTitle(objAttributes.optString("title"));
                            userAttributes.setFirstName(objAttributes.optString("first-name"));
                            userAttributes.setLastName(objAttributes.optString("last-name"));
                            userAttributes.setDob(objAttributes.optString("date-of-birth"));
                            userAttributes.setContactNumber(objAttributes.optString("contact-number"));
                            userAttributes.setEmailId(objAttributes.optString("email-address"));
                            userAttributes.setEmailIdVerified(objAttributes.optBoolean("email-address-verified"));
                            userAttributes.setEmailIdSubscriptionStatus(objAttributes.optBoolean("email-subscription-status"));
                            userData.setUserAttributes(userAttributes);
                        }
                        JSONObject objlinks = objectData.optJSONObject("links");
                        if (objlinks != null) {
                            userData.setLinkSelf(objlinks.optString("self"));
                        }

                        JSONObject objRelationship = objectData.optJSONObject("relationships");
                        if (objRelationship != null) {
                            JSONObject objRelationshipServices = objectData.optJSONObject("services");
                            if (objRelationshipServices != null) {
                                JSONObject objRelationshipServicesLinks = objectData.optJSONObject("links");
                                if (objRelationshipServicesLinks != null) {
                                    userData.setRelationShipLink(objRelationshipServicesLinks.optString("related"));
                                }
                            }
                        }
                        collectionData.setUserData(userData);
                    }

                    JSONArray array = objectParent.optJSONArray("included");
                    if (array != null && array.length() > 0) {
                        ArrayList<Details> detailsList = new ArrayList<>();
                        for (int iterator = 0; iterator < array.length(); ++iterator) {
                            JSONObject object = array.optJSONObject(iterator);
                            Details details = new Details();
                            details.setId(object.optString("id"));
                            String type = object.optString("type");
                            details.setType(type);
                            switch (type) {
                                case "services":
                                    details.setAttributes(getServiceAttributes(object, details));
                                    break;

                                case "subscriptions":
                                    details.setAttributes(getSubscriptionAttributes(object, details));
                                    break;

                                case "products":
                                    details.setAttributes(getProductAttributes(object));
                                    break;
                            }
                            detailsList.add(details);
                        }
                        collectionData.setDetails(detailsList);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collectionData;
    }

    public static Attributes getServiceAttributes(JSONObject object, Details details) {
        JSONObject objAttributes = object.optJSONObject("attributes");
        ServiceAttributes serviceAttributes = null;
        if (objAttributes != null) {
            serviceAttributes = new ServiceAttributes();
            serviceAttributes.setMsn(objAttributes.optString("msn"));
            serviceAttributes.setCredit(objAttributes.optString("credit"));
            serviceAttributes.setCreditExpiry(objAttributes.optString("credit-expiry"));
            serviceAttributes.setDataUsageThreshold(objAttributes.optBoolean("data-usage-threshold"));
        }
        JSONObject objlinks = object.optJSONObject("links");
        if (objlinks != null) {
            details.setLinkSelf(objlinks.optString("self"));
        }

        JSONObject objRelationship = object.optJSONObject("relationships");
        if (objRelationship != null) {
            JSONObject objRelationshipSubscriptions = objRelationship.optJSONObject("subscriptions");
            if (objRelationshipSubscriptions != null) {
                JSONObject objRelationshipServicesLinks = objRelationshipSubscriptions.optJSONObject("links");
                if (objRelationshipServicesLinks != null) {
                    details.setRelationShipLink(objRelationshipServicesLinks.optString("related"));
                }
            }
        }

        return serviceAttributes;
    }

    public static Attributes getSubscriptionAttributes(JSONObject object, Details details) {
        JSONObject objAttributes = object.optJSONObject("attributes");
        SubscriptionAttributes subscriptionAttributes = null;
        if (objAttributes != null) {
            subscriptionAttributes = new SubscriptionAttributes();
            subscriptionAttributes.setIncludedDataBalance(objAttributes.optString("included-data-balance"));
            subscriptionAttributes.setIncludedCreditBalance(objAttributes.optString("included-credit-balance"));
            subscriptionAttributes.setIncludedRolloverCreditBalance(objAttributes.optString("included-rollover-credit-balance"));
            subscriptionAttributes.setIncludedRolloverDataBalance(objAttributes.optString("included-rollover-data-balance"));
            subscriptionAttributes.setIncludedInternationalTalkBalance(objAttributes.optString("included-international-talk-balance"));
            subscriptionAttributes.setExpiryDate(objAttributes.optString("expiry-date"));
            subscriptionAttributes.setAutoRenewal(objAttributes.optBoolean("auto-renewal"));
            subscriptionAttributes.setPrimarySubscription(objAttributes.optBoolean("primary-subscription"));
        }
        JSONObject objlinks = object.optJSONObject("links");
        if (objlinks != null) {
            details.setLinkSelf(objlinks.optString("self"));
        }

        JSONObject objRelationship = object.optJSONObject("relationships");
        if (objRelationship != null) {
            JSONObject objRelationshipSubscriptions = objRelationship.optJSONObject("service");
            if (objRelationshipSubscriptions != null) {
                JSONObject objRelationshipServicesLinks = objRelationshipSubscriptions.optJSONObject("links");
                if (objRelationshipServicesLinks != null) {
                    details.setRelationShipLink(objRelationshipServicesLinks.optString("related"));
                }
            }
        }

        return subscriptionAttributes;
    }

    public static Attributes getProductAttributes(JSONObject object) {
        ProductAttributes productAttributes = new ProductAttributes();
        JSONObject objAttributes = object.optJSONObject("attributes");
        productAttributes.setName(objAttributes.optString("name"));
        productAttributes.setIncludedData(objAttributes.optString("included-data"));
        productAttributes.setIncludedCredit(objAttributes.optString("included-credit"));
        productAttributes.setIncludedInternationalTalk(objAttributes.optString("included-international-talk"));
        productAttributes.setUnlimitedTalk(objAttributes.optBoolean("unlimited-text"));
        productAttributes.setUnlimitedTalk(objAttributes.optBoolean("unlimited-talk"));
        productAttributes.setUnlimitedInternationalText(objAttributes.optBoolean("unlimited-international-tex"));
        productAttributes.setUnlimitedInternationalTalk(objAttributes.optBoolean("unlimited-international-talk"));
        productAttributes.setPrice(objAttributes.optInt("price"));

        return productAttributes;
    }
}
