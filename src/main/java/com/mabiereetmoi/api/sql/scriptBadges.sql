-- Catégories badge
insert into category_badge(name) values('FAVOURITE');
insert into category_badge(name) values('COMMENT');
insert into category_badge(name) values('SCAN');
insert into category_badge(name) values('ADDITION');


-- Comments
insert into badge (id, name, category_name, description, image, image_grey)
values(1, 'Il faut vaincre sa timidité!', 'COMMENT', 'Bravo tu as écrit ton 1er commentaire !', 'comment_1', 'comment1_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(2, 'C''est bien, tu t''affirmes!', 'COMMENT', 'Bravo tu as écrit ton 10ème commentaire !', 'comment_10', 'comment10_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(3, 'Débat présidentiel!', 'COMMENT', 'Bravo tu as écrit ton 20ème commentaire !', 'comment_20', 'comment20_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(4, 'Doit surveiller ses bavardages au second trimestre!', 'COMMENT', 'Bravo tu as écrit ton 50ème commentaire !', 'comment_50', 'comment50_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(5, 'Sacré pipelette!', 'COMMENT', 'Bravo tu as écrit ton 100ème commentaire !', 'comment_100', 'comment100_g');


-- Favourite
insert into badge (id, name, category_name, description, image, image_grey)
values(6, 'Mon premier flocon!', 'FAVOURITE', 'Bravo tu as liké ta 1ère bière !', 'fav1', 'fav1_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(7, 'Amateur de bon goût!', 'FAVOURITE', 'Bravo tu as liké ta 10ème bière !', 'fav10', 'fav10_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(8, 'Des étoiles pleins les verres!', 'FAVOURITE', 'Bravo tu as liké ta 20ème bière !', 'fav20', 'fav20_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(9, 'Groupie', 'FAVOURITE', 'Bravo tu as liké ta 50ème bière !', 'fav50', 'fav50_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(10, 'Fan de la première heure', 'FAVOURITE', 'Bravo tu as liké ta 100ème bière !', 'fav100', 'fav100_g');


-- Scan
insert into badge (id, name, category_name, description, image, image_grey)
values(11, 'Il y un a début à tout!', 'SCAN', 'Bravo tu as scanné ta 1ère bière !', 'scan1', 'scan1_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(12, 'Pas mal pour un débutant!', 'SCAN', 'Bravo tu as scanné ta 10ème bière !', 'scan10', 'scan10_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(13, 'Serious business!', 'SCAN', 'Bravo tu as scanné ta 20ème bière !', 'scan20', 'scan20_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(14, 'Ah ouais, ça rigole plus!', 'SCAN', 'Bravo tu as scanné ta 50ème bière !', 'scan50', 'scan50_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(15, 'Started from the bottom, now we beer!', 'SCAN', 'Bravo tu as scanné ta 100ème bière !', 'scan100', 'scan100_g');


-- Addition
insert into badge (id, name, category_name, description, image, image_grey)
values(16, 'Pichard!', 'ADDITION', 'Bravo tu as ajouté ta 1ère bière !', 'ajout1', 'ajout1_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(17, 'Amateur!', 'ADDITION', 'Bravo tu as ajouté ta 5ème bière !', 'ajout5', 'ajout5_g');
insert into badge (id, name, category_name, description, image, image_grey)
values(18, 'Connoisseur!', 'ADDITION', 'Bravo tu as ajouté ta 10ème bière !', 'ajout10', 'ajout10_g');
