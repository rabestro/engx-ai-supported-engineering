package org.epam.engx;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static java.util.function.Predicate.not;

public class HashtagGenerator {

  private static final Set<String> STOPWORDS = new HashSet<>(
      List.of("a", "an", "the", "in", "on", "at", "and", "or"));

  private final UnaryOperator<String> textPreprocessor = new TextPreprocessing();
  private final TokenizerME tokenizer;
  private final POSTaggerME posTagger;


  public HashtagGenerator() {
    TokenizerModel tokenizerModel = loadModel("/en-token.bin", TokenizerModel.class);
    POSModel posModel = loadModel("/en-pos-maxent.bin", POSModel.class);

    this.tokenizer = new TokenizerME(tokenizerModel);
    this.posTagger = new POSTaggerME(posModel);
  }

  public static void main(String[] args) {
    var hashtagGenerator = new HashtagGenerator();

    // Test the hashtag generator with a sample text
    var inputText = "Developing a social media platform using natural language processing and machine learning!";
    var generatedHashtags = hashtagGenerator.generateHashtags(inputText);

    System.out.println("Generated Hashtags:");
    generatedHashtags.forEach(hashtag -> System.out.println("#" + hashtag));
  }

  private static <T> T loadModel(String resourcePath, Class<T> modelClass) {
    try (InputStream modelIn = HashtagGenerator.class.getResourceAsStream(resourcePath)) {
      return modelClass.getConstructor(InputStream.class).newInstance(modelIn);
    } catch (Exception e) {
      throw new RuntimeException("Error loading OpenNLP model from " + resourcePath, e);
    }
  }

  public List<String> generateHashtags(String inputText) {
    var preprocessedText = textPreprocessor.apply(inputText);
    var tokens = tokenizer.tokenize(preprocessedText);
    var tags = posTagger.tag(tokens);

    return Arrays.stream(tokens)
        .filter(not(STOPWORDS::contains))
        .filter(token -> tags[Arrays.asList(tokens).indexOf(token)].startsWith("N"))
        .map(String::toLowerCase)
        .toList();
  }
}