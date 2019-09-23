package io.github.eutkin.snakecase;

import java.util.stream.Stream;

import javax.annotation.processing.ProcessingEnvironment;

import io.vertx.codegen.Generator;
import io.vertx.codegen.GeneratorLoader;

public class DataObjectHelperGeneratorLoader implements GeneratorLoader {

  @Override
  public Stream<Generator<?>> loadGenerators(ProcessingEnvironment processingEnv) {
    return Stream.of(new DataObjectHelperGenerator());
  }
}
