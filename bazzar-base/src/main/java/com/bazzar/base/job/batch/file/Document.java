package com.bazzar.base.job.batch.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Document {

	private final List<String> lines;

	Document(List<String> lines) {
		this.lines = lines;
	}

	public List<String> getLines() {
		return this.lines;
	}

	public static Document fromFile(String fileUrl) throws IOException,
	        URISyntaxException {
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = getBufferedReader(fileUrl)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		}
		return new Document(lines);
	}

	private static BufferedReader getBufferedReader(String fileUrl)
	        throws IOException, URISyntaxException {
		URL url = new URL(fileUrl);
		Charset charset = Charset.forName("UTF-8");
		if (url.toURI().getHost() == null) {
			return Files.newBufferedReader(Paths.get(url.toURI()), charset);
		} else {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setAllowUserInteraction(false);
			// conn.setDoInput(true);
			// conn.setDoOutput(true);
			conn.connect();
			return new BufferedReader(new InputStreamReader(
			        conn.getInputStream(), charset));
		}
	}
}
