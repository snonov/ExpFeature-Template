package com.snonov.explore.template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		sayHello();
	}

	public static void sayHello() {
		LOGGER.info("Hello World!");

		JtwigTemplate template = JtwigTemplate.classpathTemplate("template/pythonScript.twig");
		JtwigModel model = JtwigModel.newModel()
				.with("name", "Peter")
				.with("name2", "John")
				.with("command", "print");

		template.render(model, System.out);

		File pathExec = new File(".");
		File file = new File(pathExec.getAbsolutePath() + "target//pythonScript.py");
		FileOutputStream fop;
		try {
			fop = new FileOutputStream(file);
			template.render(model, fop);
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException", e);
		}

	}

}
