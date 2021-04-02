insert into category_beer values (1,'Rouge');
insert into category_beer values (2,'Ambrée');
insert into category_beer values (3,'Brune');
insert into category_beer values (4,'IPA');
insert into category_beer values (5,'Blonde');
insert into category_beer values (6,'Brune');

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category) values(1,'Heineken',5,5,
'La plus connue des hollandaises est blonde pâle et mousse moyennement et de façon non persistante. Son nez d''intensité moyenne à
                          faible est dominé par des odeurs d''orange amère',now(),5);

insert into beer(id_beer,name_beer,note_avg,degree_alcohol,description,create_date,category_id_category) values(2,'Kastle Rouge',5,8,
                                                                                                    'La Kasteel Rouge est un mélange unique de Kasteel Donker et de liqueur de cerises. Cette bière fruitée se savoure en cocktail ou apéritif sur une terrasse ensoleillée. Une bière pour les amateurs des arômes puissants et sucrés de cerises.',now(),1);
