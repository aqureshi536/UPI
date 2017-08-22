package com.our.utils;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.our.dao.ErrorDAO;
import com.our.model.Error;
import com.our.response.Response;

@Component(value = "utility")
public class Utility {

	private static String cUTF8 = "UTF-8";
	@Autowired
	private ErrorDAO errorDAO;

	public Response checkAccountStatus(String status) {
		Response response = new Response();
		try {
			Error error = errorDAO.getErrorCode(status);
			if (Constants.RESP_SUCCESS.equals(error.getErrorCode())) {
				response.setStatusCode(Constants.STATUS_SUCCESS);
				response.setErrorCode(error.getErrorCode());
			} else {
				response.setStatusCode(Constants.STATUS_FAILURE);
				response.setErrorCode(error.getErrorCode());
			}
			response.setErrorDesc(error.getErrorDesc());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public Response setResponse(String errorCode) {
		Response response = new Response();
		try {
			if (errorCode.equalsIgnoreCase(Constants.RESP_SUCCESS)) {
				response.setStatusCode(Constants.STATUS_SUCCESS);
				response.setErrorDesc("");
			} else {
				response.setStatusCode(Constants.STATUS_FAILURE);
				response.setErrorCode(errorCode);
				response.setErrorDesc(resolveErrorDescription(errorCode));
			}
		} catch (Exception e) {

		}
		return response;

	}

	public String resolveErrorDescription(String errorCode) {
		String desc = "";

		return desc;
	}

	public Document loadresourceXMl(String filename) throws Exception {
		InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		Document doc = dbBuilder.parse(input);
		input.close();
		return doc;
	}

	public Document stringToXml(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public static String documentToString(Document doc) {
		String xmlString = "";

		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, cUTF8);
			transformer.transform(domSource, result);
			xmlString = writer.toString();
		} catch (Exception e) {
			e.getMessage();
		}

		return xmlString;
	}

}
