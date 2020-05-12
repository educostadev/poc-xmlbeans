import static org.assertj.core.api.Assertions.assertThat;

import br.gov.bcb.pi.admi002.x13.EnvelopeDocument;
import java.io.IOException;
import java.io.InputStream;
import org.apache.xmlbeans.XmlException;
import org.junit.jupiter.api.Test;

/**
 * @see https://xmlbeans.apache.org/docs/3.0.0/guide/conGettingStartedwithXMLBeans.html
 */

class XMLToPOJOTest {

  @Test
  void shouldParseXMLToPOJOWhenXMLValid() throws IOException, XmlException {
    //GIVEN
    InputStream xmlStream = XMLToPOJOTest.class.getResourceAsStream("admi.002_SPI_M_msg.xml");

    //WHEN
    EnvelopeDocument xmlPOJO = EnvelopeDocument.Factory.parse(xmlStream);

    //THEN
    assertThat(xmlPOJO).isNotNull();
    assertThat(
        xmlPOJO.getEnvelope().getAppHdr().getFr().getFIId().getFinInstnId().getOthr().getId())
        .isEqualTo("00038166");
  }

}
