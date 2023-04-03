package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */
  @Test
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Existujici", 1,1);
    assertTrue(svatky.jeVSeznamu("Existujici"));
    assertFalse(svatky.jeVSeznamu("Neexistujici"));
    //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getPocetJmen());
    //TODO Otestovat, že vrací počet jmen, která máme v seznamu
  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */
  @Test
  void getSeznamJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getSeznamJmen().size());
    //TODO Zkontrolovat, že seznam jmen má správný počet položek.
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Existujici", 1,1);
    assertEquals(MonthDay.of(1, 1), svatky.kdyMaSvatek("Existujici"));
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Existujici", 1, Month.of(1));
    assertEquals(MonthDay.of(1, 1), svatky.kdyMaSvatek("Existujici"));
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void prridatSvatekMonthDay() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Existujici", MonthDay.of(1, 1));
    assertEquals(MonthDay.of(1, 1), svatky.kdyMaSvatek("Existujici"));
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getPocetJmen());
    svatky.pridatSvatek("Existujici", 1,1);
    assertEquals(38, svatky.getPocetJmen());
    svatky.smazatSvatek("Existujici");
    assertEquals(37, svatky.getPocetJmen());

    //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
  }
}
