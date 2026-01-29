# Projekt: Android Väderapp 🌤️

Detta projekt syftar till att utveckla en Android-applikation som hämtar, bearbetar och presenterar väderdata från en extern källa.

## 🎯 Mål
Huvudmålet med projektet är att skapa en fungerande applikation som:
1. Hämtar aktuell väderdata från nätet.
2. Läser av (parsar) informationen.
3. Presenterar vädret för användaren på ett grafiskt tilltalande och tydligt sätt.

## 🛠️ Ingående moment och Tekniker
Projektet kommer att beröra och examinera följande tekniska områden inom Android-utveckling:
* **GUI (Graphical User Interface):** Design av användargränssnitt.
* **Webbdata:** Hämtning av data över internet.
* **XML-parsning:** Hantering och utläsning av strukturerad data.
* **Trådning (Threading):** Hantering av processer utanför huvudtråden.
* **AsyncTask:** För asynkron datahämtning (bakgrundsarbete).

## 📱 Innehåll & Funktionalitet
Applikationen ska presentera **dagens väder** baserat på en specifik plats. Informationen ska visualiseras med både text och bild.

### Grafisk representation
* En bild ska visas som på ett "någorlunda rättvist sätt" återspeglar det aktuella vädret (t.ex. en sol vid klart väder, moln vid mulet).

### Textinformation
Appen ska som minst presentera följande data:
* 🌧️ **Nederbörd:** Om det regnar.
* 💨 **Vind:** Hur mycket det blåser.
* 🌡️ **Temperatur:** Aktuella grader.
* ☁️ **Molnighet:** Hur molnigt det är.

## 🔗 Referenser och API
Väderdata hämtas från **met.no**.


**API-anrop (XML):**