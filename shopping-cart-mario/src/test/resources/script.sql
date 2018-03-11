INSERT INTO CLIENT as cli(cli.ID, cli.DESCRIPTION, cli.FIRSTNAME, cli.LASTNAME)
VALUES
  (1, 'FuturoJavaDev', 'mario', 'Rodriguez');

INSERT INTO PEDIDO as ord (ord.ID, ord.NAME) VALUES
  (1, 'Order1');

INSERT INTO ITEM as item (item.ID, item.NAME , item.PEDIDO_ID,)
VALUES
  (1,'Item1',1),
  (2,'Item2',1),
  (3,'Item3',1);


