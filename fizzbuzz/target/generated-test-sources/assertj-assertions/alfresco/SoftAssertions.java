package alfresco;

/**
 * Entry point for soft assertions of different data types.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class SoftAssertions extends org.assertj.core.api.SoftAssertions {

  /**
   * Creates a new "soft" instance of <code>{@link alfresco.AppAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public alfresco.AppAssert assertThat(alfresco.App actual) {
    return proxy(alfresco.AppAssert.class, alfresco.App.class, actual);
  }

}
