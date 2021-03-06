package com.erutulco.notieimberisseo.lang;

import java.util.HashMap;

public class LangManager {

  private static final String[] languages = {
      "Quenya", "QuenyaTengwar", "English", "Espanol", "Deutsch", "Russian"
  };
  private static final String[] languages_short = {
      "qya", "qyt", "eng", "esp", "deu", "rus"
  };
  private static final String[] languages_printable = {
      "Quenya", "Quenya Tengwar (Beta)", "English", "Español", "Deutsch", "русский"
  };

  private HashMap<String, Lang> langs;
  private Lang definedLang;

  public static String[] getLanguages() {
    return languages;
  }

  public static String[] getLanguagesShort() {
    return languages_short;
  }

  public static String[] getLanguagesPrintable() {
    return languages_printable;
  }

  public HashMap<String, Lang> getLangs() {
    return langs;
  }

  public void setLangs(HashMap<String, Lang> langs) {
    this.langs = langs;
  }

  public Lang getDefinedLang() {
    return definedLang;
  }

  public void setDefinedLang(Lang definedLang) {
    this.definedLang = definedLang;
  }

  private static LangManager instance = null;

  /**
   * Singleton method for LangManager.
   * @return LangManager instance of the com.erutulco.notieimberisseo.lang manager.
   */
  public static LangManager getInstance() {
    if (LangManager.instance == null) {
      LangManager.instance = new LangManager();
    }
    return LangManager.instance;
  }

  private LangManager() {
    HashMap<String, Lang> langs = new HashMap<String, Lang>();
    /* Load langs */
    for (int i = 0; i < LangManager.languages.length; i++) {
      String language = LangManager.languages[i];
      ClassLoader classLoader = LangManager.class.getClassLoader();
      try {
        Class<?> langClass = classLoader.loadClass(
            "com.erutulco.notieimberisseo.lang.available.Lang" + language
        );
        Lang lang = (Lang) langClass.newInstance();
        langs.put(lang.getShortName(), lang);
      } catch (ClassNotFoundException e) {
        System.err.println(e.getMessage());
      } catch (InstantiationException e) {
        System.err.println(e.getMessage());
      } catch (IllegalAccessException e) {
        System.err.println(e.getMessage());
      }
    }
    this.setLangs(langs);
  }

  public LangManager clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /**
   * Define an existing com.erutulco.notieimberisseo.lang.
   * @param shortName Short name of the language
   * @return boolean Success/error
   */
  public boolean defineLang(String shortName) {
    boolean exists = this.getLangs().containsKey(shortName);
    if (exists) {
      Lang lang = this.getLangs().get(shortName);
      lang.defineLang();
      this.setDefinedLang(lang);
    }
    return exists;
  }

}
