import static org.assertj.core.api.Assertions.assertThat;

import br.gov.bcb.pi.admi002.x13.EnvelopeDocument;
import org.junit.jupiter.api.Test;

class POJOToXMLTest {


  @Test
  void shouldParsePOJOTToXMLWhenPOJOValid() {
    //GIVEN
    EnvelopeDocument pojo = EnvelopeDocument.Factory.newInstance();
    pojo.addNewEnvelope().addNewAppHdr().addNewFr().addNewFIId().addNewFinInstnId().addNewOthr()
        .setId("00038166");

    //WHEN
    String xml = pojo.xmlText();
    System.out.println(xml);

    //THEN
    assertThat(xml).contains("00038166");
  }
}
