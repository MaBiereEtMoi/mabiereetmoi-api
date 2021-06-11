-- Catégories badge
insert into category_badge(name) values('FAVOURITE');
insert into category_badge(name) values('COMMENT');
insert into category_badge(name) values('SCAN');
insert into category_badge(name) values('ADDITION');


-- Comments
insert into badge (id, name, category_name, description)
values(1, 'Il faut vaincre sa timidité!', 'COMMENT', 'Bravo tu as écrit ton 1er commentaire !' );
insert into badge (id, name, category_name, description)
values(2, 'C''est bien, tu t''affirmes!', 'COMMENT', 'Bravo tu as écrit ton 10ème commentaire !');
insert into badge (id, name, category_name, description)
values(3, 'Débat présidentiel!', 'COMMENT', 'Bravo tu as écrit ton 20ème commentaire !');
insert into badge (id, name, category_name, description)
values(4, 'Doit surveiller ses bavardages au second trimestre!', 'COMMENT', 'Bravo tu as écrit ton 50ème commentaire !');
insert into badge (id, name, category_name, description)
values(5, 'Sacré pipelette!', 'COMMENT', 'Bravo tu as écrit ton 100ème commentaire !');


-- Favourite
insert into badge (id, name, category_name, description)
values(6, 'Mon premier flocon!', 'FAVOURITE', 'Bravo tu as liké ta 1ère bière !');
insert into badge (id, name, category_name, description)
values(7, 'Amateur de bon goût!', 'FAVOURITE', 'Bravo tu as liké ta 10ème bière !');
insert into badge (id, name, category_name, description)
values(8, 'Des étoiles pleins les verres!', 'FAVOURITE', 'Bravo tu as liké ta 20ème bière !');
insert into badge (id, name, category_name, description)
values(9, 'Groupie', 'FAVOURITE', 'Bravo tu as liké ta 50ème bière !');
insert into badge (id, name, category_name, description)
values(10, 'Fan de la première heure', 'FAVOURITE', 'Bravo tu as liké ta 100ème bière !');


-- Scan
insert into badge (id, name, category_name, description)
values(11, 'Il y un a début à tout!', 'SCAN', 'Bravo tu as scanné ta 1ère bière !');
insert into badge (id, name, category_name, description)
values(12, 'Pas mal pour un débutant!', 'SCAN', 'Bravo tu as scanné ta 10ème bière !');
insert into badge (id, name, category_name, description)
values(13, 'Serious business!', 'SCAN', 'Bravo tu as scanné ta 20ème bière !');
insert into badge (id, name, category_name, description)
values(14, 'Ah ouais, ça rigole plus!', 'SCAN', 'Bravo tu as scanné ta 50ème bière !');
insert into badge (id, name, category_name, description)
values(15, 'Started from the bottom, now we beer!', 'SCAN', 'Bravo tu as scanné ta 100ème bière !');


-- Addition
insert into badge (id, name, category_name, description)
values(16, 'Pichard!', 'ADDITION', 'Bravo tu as ajouté ta 1ère bière !');
insert into badge (id, name, category_name, description)
values(17, 'Amateur!', 'ADDITION', 'Bravo tu as ajouté ta 5ème bière !');
insert into badge (id, name, category_name, description)
values(18, 'Connoisseur!', 'ADDITION', 'Bravo tu as ajouté ta 10ème bière !');
