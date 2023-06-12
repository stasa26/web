INSERT INTO KORISNIK (ime, prezime, korisnicko_ime, email, password, datum_rodjenja, slika, opis, uloga, admin) VALUES ('Mika', 'Mikic', 'coolguy1', 'a@a.a', 'jakalozinka2', '2002-06-18', 'slika.jpg', 'Jako sam cool', 'CITALAC', false);
INSERT INTO KORISNIK (ime, prezime, korisnicko_ime, email, password, datum_rodjenja, slika, opis, uloga, admin) VALUES ('Ivan', 'Ivanovic', 'admin', 'b@b.b', 'admin', '1989-23-01', 'slika.jpg', 'Admin hehe', 'ADMINISTRATOR', true);

INSERT INTO KORISNIK (ime, prezime, korisnicko_ime, email, password, datum_rodjenja, slika, opis, uloga, admin) VALUES ('Ivo', 'Andric', 'coolguy1', 'c@c.c', 'jakalozinka2', '1212-12-12', 'slika.jpg', 'Prvi autor', 'AUTOR', false);
INSERT INTO AUTOR (aktivan, id) VALUES (true, 3);

INSERT INTO ZANR (naziv) VALUES ('Akcija');
INSERT INTO ZANR (naziv) VALUES ('Romantika');
INSERT INTO ZANR (naziv) VALUES ('Klasicna');

INSERT INTO KNJIGA (naslov, naslovna_fotografija, isbn, objavljena, broj_strana, opis, autor_id) VALUES ('Na Drini Cuprija', 'slika.jpg', '11111111111', '1313-13-13', 1000, 'knjiga o mostu', 3);

INSERT INTO RECENZIJA (ocena, tekst, datum, korisnik_id) VALUES (10, 'dobra', '2011-11-11', 1);

INSERT INTO POLICA (naziv, primarna, korisnik_id) VALUES ('Read', true, 1);

INSERT INTO STAVKA (recenzija_id, knjiga_id) VALUES (1, 1);

INSERT INTO POLICA_STAVKE (polica_id, stavke_id) VALUES (1, 1);

INSERT INTO ZAHTEV_ZA_PRIHVATANJE_AUTORA (email, telefon, poruka, datum, status) VALUES ('c@c.c', '+111 111 111', 'zelim da budem autor', '2023-04-04', 'ODOBREN');

INSERT INTO KNJIGA_ZANR (knjiga_id, zanr_id) VALUES (1, 1);
INSERT INTO KNJIGA_ZANR (knjiga_id, zanr_id) VALUES (1, 2);
INSERT INTO KNJIGA_ZANR (knjiga_id, zanr_id) VALUES (1, 3);

