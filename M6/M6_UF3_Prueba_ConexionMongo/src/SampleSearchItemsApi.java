/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

/*
 * ProductAdvertisingAPI
 *
 * https://webservices.amazon.com/paapi5/documentation/index.html
 */

/*
 * This sample code snippet is for ProductAdvertisingAPI 5.0's SearchItems API
 * For more details, refer:
 * https://webservices.amazon.com/paapi5/documentation/search-items.html
 */

import java.util.ArrayList;
import java.util.List;

import com.amazon.paapi5.v1.ApiException;
import com.amazon.paapi5.v1.ErrorData;
import com.amazon.paapi5.v1.PartnerType;
import com.amazon.paapi5.v1.SearchItemsRequest;
import com.amazon.paapi5.v1.SearchItemsResource;
import com.amazon.paapi5.v1.SearchItemsResponse;

public class SampleSearchItemsApi {

	public SampleSearchItemsApi(String keywords) {
		/*
		 * Choose resources you want from SearchItemsResource enum For more details,
		 * refer: https://webservices.amazon.com/paapi5/documentation/search-items.html#
		 * resources-parameter
		 */
		List<SearchItemsResource> searchItemsResources = new ArrayList<SearchItemsResource>();
		searchItemsResources.add(SearchItemsResource.ITEMINFO_TITLE);
//        searchItemsResources.add(SearchItemsResource.OFFERS_LISTINGS_PRICE);
		searchItemsResources.add(SearchItemsResource.IMAGES_PRIMARY_LARGE);
//        searchItemsResources.add(SearchItemsResource.BROWSENODEINFO_BROWSENODES_SALESRANK);
		searchItemsResources.add(SearchItemsResource.BROWSENODEINFO_WEBSITESALESRANK);

		searchItemsResources.add(SearchItemsResource.OFFERS_LISTINGS_PRICE);

		/*
		 * Specify the category in which search request is to be made For more details,
		 * refer:
		 * https://webservices.amazon.com/paapi5/documentation/use-cases/organization-of
		 * -items-on-amazon/search-index.html
		 */
		String searchIndex = "All";

		// Sending the request
		SearchItemsRequest searchItemsRequest = new SearchItemsRequest().partnerTag(ConexionAPI.PARTNERTAG)
				.keywords(keywords).searchIndex(searchIndex).resources(searchItemsResources)
				.partnerType(PartnerType.ASSOCIATES);

		try {
			// Forming the request
			SearchItemsResponse res = ConexionAPI.api.searchItems(searchItemsRequest);

			System.out.println("URL: " + res.getSearchResult().getSearchURL());
			System.out.println("Resultados Totales: " + res.getSearchResult().getTotalResultCount());
			System.out.println("--------------------------------");
			for (int i = 0; i < res.getSearchResult().getItems().size(); i++) {
				System.out.println("Imagen: "
						+ res.getSearchResult().getItems().get(i).getImages().getPrimary().getLarge().getURL());
				System.out.println("Titulo: "
						+ res.getSearchResult().getItems().get(i).getItemInfo().getTitle().getDisplayValue());
				System.out.println("Precio: " + res.getSearchResult().getItems().get(i).getOffers().getListings().get(0)
						.getPrice().getAmount());
				System.out.println("--------------------------------");
			}

			if (res.getErrors() != null) {
				System.out.println("Printing errors:\nPrinting Errors from list of Errors");
				for (ErrorData error : res.getErrors()) {
					System.out.println("Error code: " + error.getCode());
					System.out.println("Error message: " + error.getMessage());
				}
			}
		} catch (ApiException exception) {
			// Exception handling
			System.out.println("Error calling PA-API 5.0!");
			System.out.println("Status code: " + exception.getCode());
			System.out.println("Errors: " + exception.getResponseBody());
			System.out.println("Message: " + exception.getMessage());
			if (exception.getResponseHeaders() != null) {
				// Printing request reference
				System.out.println("Request ID: " + exception.getResponseHeaders().get("x-amzn-RequestId"));
			}
			// exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Exception message: " + exception.getMessage());
			// exception.printStackTrace();
		}
	}
}