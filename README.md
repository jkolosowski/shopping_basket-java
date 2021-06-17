# Shopping basket
Implementacja logiki koszyka dla sklepu internetowego.

Jedną z podstawowych funkcjonalności jest oprogramowanie koszyka zakupów, 
który potrafi uwzględniać różne promocje, rabaty oraz oferty specjalne, takie jak:
- jeśli wartość zamówienia jest większa niż 300 zł klient otrzymuje 5% zniżki na zakupione towary
- jeśli klient kupi 2 produkty to 3 najtańszy otrzymuje gratis
- jeśli wartość zamówienia przekracza wartość 200 zł klient otrzymuje firmowy kubek gratis
- jednorazowy kupon rabatowy 30% na wybrany produkt

Towary w koszyku są posegregowane malejąco według ceny, 
a potem według kolejności alfabetycznej nazw produktów.

1. Wyszukiwanie najtańszego/najdroższego produktu w zadanej kolekcji produktów
2. Wyszukiwanie n najtańszych/najdrożyszych produktów w zadanej kolekcji produktów
3. Sortowanie kolekcji produktów po cenie jak i po nazwie
4. Wyliczanie sumy cen wszystkich zadanych produktów
5. Wyświetlanie w konsoli informacji o wszystkich produktach w zadanej kolekcji produktów
6. Aplikowanie opisanych powyżej rodzajów promocji na zadanej kolekcji produktów

Projekt pzawiera również zawiera odpowiednie testy jednostkowe do implementowanej funkcjonalności.
