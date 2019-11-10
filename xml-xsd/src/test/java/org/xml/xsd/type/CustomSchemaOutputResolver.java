package org.xml.xsd.type;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class CustomSchemaOutputResolver extends SchemaOutputResolver {
	 
	private File file;

	public CustomSchemaOutputResolver(String dir, String fileName) {
		try {
			file = new File(dir, fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		return new StreamResult(file);
	}
}
