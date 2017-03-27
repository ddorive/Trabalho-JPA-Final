# jpa-Questionario 
Questionario JPA - Pós-Graduação.

@MappedSuperclass--> Utilizado para mapear uma super classe, onde uma classe abstrata ou concreta fornece informações de estado de entidade persistente e mapeamento para suas subclasses, porem a mesma não e uma Entidade, uma Super classe mapeada não pode realizar consultas e relacionamentos, a superclasse mapeada e unidirecional, sendo assim não aceita associações do tipo "um para muitos", tendo como finalidade definir informações de estado e mapeamento para outras entidades.

@Version--> Utilizada para mapear atributo de versionamento, ou seja, todas as vezes que houver uma transação é gerado uma versão para a instancia, se a mesma estiver sendo consultada ao mesmo tempo por mais de um usuário, a aplicação pode identificar se houve ou não alteração comparando as versões, este controle e feito pelo Optimistic concurrency  Control (OCC), onde se acredita que a possibilidade e que mais de um usuário realize a mesma instancia e mínima, porem se ocorrer o @Version, ira gerenciar informando qual a versão mais nova, fazendo com que o usuário atualize o dado ou realize uma nova solicitação.
@Entity--> Se trata de "objeto" utilizado para persistir uma tabela no banco de dados, sendo que cada instancia da entidade se trata de uma linha da tabela, uma entity e baseada em uma simples classe tipo POJO,Plain Old Java Object, sendo assim e uma classe Java comum com anotações ou informações mais especifica ao gerenciador das entidades.

@Table--> Utilizada para indica detalhes da tabela do Banco de dado que a entidade representara, sendo assim, especifica a tabela primaria para entidade anotada, sendo que tabelas adicionas podem ser especificada pela mesma entidade, para isto e preciso utilizar as anotações SecondaryTable ou SecondaryTablesanotação.
@Id--> Utilizado para definir a chave primaria, esta e responsável para determinar que o objeto seja único, pois não a duas instâncias com mesma chave primaria, sendo assim, a coluna com a anotação @Id será mapeada como chave primaria da entidade, caso não seja determinada uma, o nome da coluna da chave primaria assume como sendo o campo da chave primaria.
@GeneratedValue--> Utilizado para mapear um gerador de valores para chave primaria, este se encarregará em gerar o valor para chave primaria, determinada pela anotação @Id.
@Column--> Utilizado para indicar detalhes sobre a coluna ou linha da tabela que um atributo representa, o mesmo pode informar ao banco de dados o tamanho da coluna, se aceitara ou não o campo como NULL dentre outros.
@Basic--> Utilizado para especifica se a coluna será NULL ou NOTNULL e para especificar se o carregamento será LAZY ou EAGER.
O uso da anotação Basic é opcional para campos persistentes e propriedades desse tipo. E o tipo mais simples de mapeamento para uma coluna no banco de dados. As opções Lazy ou Eager, define se o valor do campo deve ou não ser buscado, isto e muito útil para melhorar o tempo de um requisito ao um servidor, se não for informado por padrão e utilizado o Eager, que realizara a busca do campo.

@Temporal-->Esta anotação é utilizada junto com os campos DATE e Calendar para o mapeamento das mesma, pode ser utilizada em conjunto com as anotações @Id, @Basic e @ElementCollection, senda a última apenas para coleções de elemento do tipo temporal.

@ManyToOne--> Anotação utilizada para definir uma associação de muito para um, ou seja, define uma associação de valor único 
para outra classe de entidade que tem multiplicidade de vários para um. Caso o relacionamento for Bidirecional, o OneToMany
do lado da entidade não proprietária deverá utilizar o MappedBy para especifica o campo de relacionamento ou propriedade da
entidade que é o proprietário do relacionamento.

@OneToMany--> Segue o princípio da anotação @ManyToOne, porem o relacionamento e de um para muitos, onde um elemento estará
para muitos da tabela oposta.

@OneToOne--> Relacionamento um para um, segue o princípio da anotação @ManyToOne, porem cria o relacionamento de um para um.

@ManyToMany--> Anotação utilizado para definir associação de muitos para muitos, segue basicamente as mesmas regras do ManyToOne.

@JoinColumn--> Anotação utilizado para "juntar" ou unir duas ou mais colunas, usada para detalhar a junção dos relacionamentos,

@*ToMan, Especificando uma coluna para unir uma associação de entidade ou coleção de elementos, ao unir duas colunas, será gerado
uma nova coluna com o resultado das soma das duas colunas anteriores.

@JoinTable--> Especifica Tabelas para unir associações ou coleções, deferente do JoinColunm, o JoinTable, unira todos os elementos
de duas tabelas para formar uma nova tabela, sendo esta resultado das duas anteriores, pode-se definir quais elementos de cada 
tabela será unido, podendo gerar novas tabelas com parte ou todo o conteúdo das tabelas unidas.

Transações com o Banco de dados:

Qual a responsabilidade/ objetos dos métodos do EntityManager:

isOpen --> Abre uma transação junto ao BD.
close --> Fecha uma transação junto ao BD.
createQuery --> Cria uma nova "pesquisa" ou "Pergunta" junto ao BD.
find --> Realiza uma busca "Find" no BD de uma entidade, "objeto" ou coleção.
merge --> E utilizado quando se realiza alteração do dados de uma instancia já existente no BD, o merge realiza a "Atualização" ou 
alteração em questão.
persist --> Salva uma nova instancia no BD, é o mesmo que "Gravar" ou "salvar" instancia.
remove --> Realiza a retirada de uma instancia, e o mesmo que "apagar" ou "Deletar", este comando informa ao BD para excluir a 
instacia do banco.

Todos os comando para o BD só são finalizado quando realizado o commit, antes do comando todas as ações são realizado apenas em
memoria, caso aja a necessidade de cancelar a ação basta fechar a transação sem realizar o commit.

Como instanciar Criteria do Hibernate através do EntityManager?

Exemplo:
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> query = builder.createQuery(Product.class);
Root<Product> from = query.from(Product.class);
CriteriaQuery<Product> select = query.select(from);
 
TypedQuery<Product> typedQuery = entityManager.createQuery(select);
List<Product> results = typedQuery.getResultList();

Como abrir uma transação?

em.getTransaction().begin();

Begin() informa a abertura de uma conexão

em.isOpen()
abre uma transação com o Banco de dados.

Como Fechar uma transação?

em.getTransaction().commit();
Commit ou comitar, informa que uma transação foi gravada no banco e a transação foi fechada.

em.close()
Fecha uma transação em aberto

Como Criar e executar uma querycom JPQL?

Query query = entityManager.createQuery("SELECT p FROM Product p");
List results = query.getResultList();

Qual a responsabilidade dos valores FetchType.LAZY e fetchType.EAGER?

EAGER, quando utilizado esta opção, será carregado toda a coleção a partir do PAI, ou seja, se solicitar uma busca em produto,
será carregado os cliente, forma de pagamento, dentre outras que esteja interligada ao PAI, também será carregado todos os produtos,
nome, quantidade. . . sendo assim o carregamento EAGER carrega toda a lista de coleções a partir do PAI.

LAZY, ou carregamento preguiçoso, e utilizado quando se faz uma busca e não há a necessidade de carregar toda a coleção à partir do
PAI, sendo assim, se buscar nome.produto, vira apenas os nomes do produto, não sendo carregado os demais objetos ou atributos 
como, quantidade, tipos. . . O Lazy Loading nada mais é do que, a informação desejada só será trazida do banco de dados quando ela for acessada.

Qual a responsabilidade dos valores CascadeType.PERSIST e CascadeType.REMOVE?

O atributo cascade e utilizado para aplicar uma ação na forma de cascata, por exemplo, alterar o nome do cliente a partir da inserção
do produto, onde será alterado o produto e na forma de um "Cascata" o nome do cliente na tabela Cliente.

PERSIST, Ao persistir uma entidade, também persistem as entidades mantidas neste campo.
REMOVE, Ao excluir uma entidade, exclua também as entidades mantidas neste campo.


Como fazer um Batch(DELETE ou UPDATE) através do EntityManager?

Para realizar DELETE
		EntityManager entityManager = JPAUtility.getEntityManager();	
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		//inicianado o DELETE
		entityManager.getTransaction().begin();//Abrindo Transação 
		entityManager.remove(em);//Removendo instancia
		entityManager.getTransaction().commit();//Gravando no BAnco de dados
		entityManager.close(); //Fechando Transação
		JPAUtility.close();		
		System.out.println("Entity removida.");
		
entityManager.remove, irá se encarregar de excluir a Entidade ou coleção.

Para realizar um UPDATE

EntityManager entityManager = JPAUtility.getEntityManager();	
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		System.out.println("Name:"+ emp.getName()+", Cidade:"+ emp.getCidade());
	    //iniciando "Atualização"
	    entityManager.getTransaction().begin(); //Abrindo Transação 
		em.setName("Aluno"); Setando nome
		em.setCidade("Goiania");setando cidade
		entityManager.getTransaction().commit(); 
		em = entityManager.find(Employee.class, new Integer(1));
		entityManager.close(); 
		JPAUtility.close();	//Fechando Transação			
		System.out.println("Name:"+ emp.getName()+", Cidade:"+ emp.getCidade());
		System.out.println("Entity updated.");

Procure a entidade usando o find()método. A instância de entidade retornada estará no contexto de persistência.
Ao aplicar o "em.set***", e o mesmo que informar ao BD dados quais o dados que estão
sendo incerido, apos incerir plica-se o COMMIT, que ira gravar as informações.
Altere a mesma
aplique um Commit.


Qual a explicação para a exception LazyInitializationException?

exception LazyInitializationException ocorre quando se tenta carregar uma solicitação de coleção LAZY, porem a coleção do banco de dados 
foi fechada, sendo assim, devido a falta de uma conexão em aberto durante o carregamento LAZY, o erro ocorre, pois JPA tenta realizar o
pedido porem não há mais uma conexão ativa com o banco.


