Az alábbi alkalmazás a következő weboldall automatizálja: http://test-automation-shop2.greenfox.academy/
Az alkalmazás az alábbi funkcikat teszteli:

                                            -Regisztráció
                                            -Bejelentkezés/Kijelentkezés
                                            -Termékek rendezése
                                            -Kosárba helyezés/Korás tartalmának eltávolítása
                                            -Termék értékelése
                                            -KÖvetkező adatlista betöltése
                                            -Felhasználói adat módosítás
                                            
                                          
A manuális teszteseket ezen a linken találhatók: https://docs.google.com/spreadsheets/d/1Wp9SWfCbG9QF_WrobcRDf4v2Vi5zRcoiH3zY5y4mT84/edit?usp=sharing


Forkold a repositoryt majd clone-ozd le a saját gépedre. Szükség lesz az Allure Framework-re, aminek a telepítéséhez a következő oldalon találsz segítséget: https://docs.qameta.io/allure/ , és a Gradle Build Tool-ra amineek a telepítéséhez itt találsz segítséget: https://gradle.org/install/ 
A parancssorban navigálj a root könyvtába és add ki a gradlew test parancsot.
Ez után add ki a allure serve <path to your Allure-results folder> parancsot.
