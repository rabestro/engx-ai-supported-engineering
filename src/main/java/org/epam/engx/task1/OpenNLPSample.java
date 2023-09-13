package org.epam.engx.task1;

import static java.util.Objects.requireNonNull;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class OpenNLPSample {

  public static void main(String[] args) {
    System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");

    try {
      // Load the tokenizer model from the resources folder
      var modelIn = OpenNLPSample.class.getResourceAsStream("/en-token.bin");
      requireNonNull(modelIn, "Model not found");
      var model = new TokenizerModel(modelIn);

      // Instantiate the tokenization tool
      var tokenizer = new TokenizerME(model);

      // Tokenize a sample text
      var sampleText = "This is an example sentence to tokenize.";
      var tokens = tokenizer.tokenize(sampleText);

      // Print the tokens
      for (String token : tokens) {
        System.out.println(token);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}