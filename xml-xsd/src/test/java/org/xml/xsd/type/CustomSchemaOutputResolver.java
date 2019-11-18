package org.xml.xsd.type;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class CustomSchemaOutputResolver extends SchemaOutputResolver {
	private OutputStream out;
	private boolean closeable;

	public CustomSchemaOutputResolver(String dir, String fileName) {
		try {
			File file = new File(dir, fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			this.out = new FileOutputStream(file);
			this.closeable = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CustomSchemaOutputResolver(OutputStream out) {
		this.out = out;
	}

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		try{
			StreamResult r = new StreamResult(this.out);
			r.setSystemId("system.out");
			return r;
		}finally {
			if(this.closeable) {
				try{
					this.out.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
