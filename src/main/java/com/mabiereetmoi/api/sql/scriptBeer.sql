insert into category_beer values (1,'Rouge');
insert into category_beer values (2,'Ambrée');
insert into category_beer values (3,'Brune');
insert into category_beer values (4,'IPA');
insert into category_beer values (5,'Blonde');
insert into category_beer values (6,'Brune');
insert into category_beer values (7,'Noire');
insert into category_beer values (8,'Blanche');

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category) values(1,'Heineken',2,5,
'La plus connue des hollandaises est blonde pâle et mousse moyennement et de façon non persistante. Son nez d''intensité moyenne à
                          faible est dominé par des odeurs d''orange amère',now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category) values(2,'Kasteel Rouge',5,8,
                                                                                                    'La Kasteel Rouge est un mélange unique de Kasteel Donker et de liqueur de cerises. Cette bière fruitée se savoure en cocktail ou apéritif sur une terrasse ensoleillée. Une bière pour les amateurs des arômes puissants et sucrés de cerises.',now(),1);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(3,'Tripel Karmeliet',5,8.4,
       'La bière Tripel Karmeliet est l''un des grands classiques des bières belges. ' ||
       'Selon la brasserie Bosteels, la recette utilisée serait la même depuis 1679.',
       now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(4,'Anosteké IPA',5,6,
       'Issue de la Brasserie du Pays Flamand, l''Anosteke IPA est une bière de type India Pale Ale, brassée dans ' ||
       'le nord de la France à partir de 3 houblons américains, qui lui confère son caractère houblonné si particulier.',
       now(),4);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(5,'Guinness',4,4.2,
       'La Guinness est la bière symbole de l''Irlande par excellence. Brassée à Dublin depuis 1759, elle a su devenir ' ||
       'un des emblèmes forts de ce pays. Cette bière est reconnue entre mille par son onctuosité, sa robe noire et ' ||
       'ses saveurs torréfiées.',
       now(),7);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(6,'Chouffe',4,8.2,
       'La chouffe est une belgian Pale Ale blonde non filtrée et refermentée. Derrière une robe couleur or, ' ||
       'on découvre avec enchantement un bouquet aromatique à la fois fruitée et épicé. ',
       now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(7,'Duvel',4,8.7,
       'La bière Duvel est une bière belge fruitée dont la réputation n''est plus à faire ! ' ||
       'Autrefois vendue sous le nom de Victory Ale, cette bière qui sera ensuite surnommé "le Diable en bouteille" ' ||
       'finira par porter avec fierté ce sobriquet puisque le mot "Duvel" signifie "diable" en patois flamand !',
       now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(8,'Gulden Draak',4,10.7,
       'La Gulden Draak ... une main de fer dans un gant de velours ! Avec sa bouteille blanche aux allures légères et' ||
       ' innocentes, la Gulden Draak tente de tromper son monde mais c''est sans compter sur la transparence de la ' ||
       'verrerie! Car une fois dans son verre, c''est bel et bien une bière brune qui s''échappe de la bouteille blanche au petit dragon doré !',
       now(),6);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(9,'Hoegaarden Wit-Blanche',3,4.9,
       'La Hoegaarden est une bière belge blanche qui compte parmi les plus connues hors du royaume de Belgique. ' ||
       'C''est la seule bière blanche à être proposée en fûts de 6L PerfectDraft ce qui la rend incontournable !',
       now(),8);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(10,'Paix Dieu',5,10,
       'La production restreinte de la Paix Dieu est régulée par le calendrier lunaire afin de conserver l''âme de ' ||
       'l''abbaye en ne la brassant qu''une seule fois par mois lors de la pleine lune. Cette triple artisanale de ' ||
       'tradition donne un résultat plein de caractère avec des ingrédients sélectionnés avec soin auprès des producteurs locaux.',
       now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(11,'Brunehaut Bio Ambrée',3,6.5,
       'Versée dans un verre, la Brunehaut Ambrée Bio dévoile une jolie robe rousse surmontée d''une belle mousse blanc cassé.',
       now(),2);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category)
values(12,'kwak',4,8.4,
       'Depuis sa fondation en 1791 par Evarist Bosteels, la brasserie Bosteels est devenue la définition de l''entreprise familiale. Dans la même famille depuis plus de 200 ans, la brasserie a
été dirigée par sept générations de la famille Bosteels, brassant certaines bières les plus emblématiques de la Belgique.',
       now(),2);

update beer set image = lo_import('C:\Users\gabri\mabiereetmoi\beer_images\kasteel_rouge.jpg') where id_beer = 2;
