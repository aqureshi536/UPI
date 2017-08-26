package com.our.test;

import org.w3c.dom.Document;

import com.our.utils.Constants;
import com.our.utils.Utility;

public class Test {

	public static void main(String[] args) {
		Utility u = new Utility();
		try {
			Document errorMappingDoc = u.loadresourceXML(Constants.ERROR_MAPPING_DOC);
			u.documentToString(errorMappingDoc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
