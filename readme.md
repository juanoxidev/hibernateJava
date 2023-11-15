# Hibernate
[HQL Teoria](https://docs.jboss.org/hibernate/orm/3.5/reference/es-ES/html/queryhql.html)
[HQL Teoria 2](https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm)
[Criteria Teoria](https://docs.jboss.org/hibernate/orm/3.5/reference/es-ES/html/querycriteria.html)

## Session Factory Interface
Lee el archivo de configuracion hibernate.cfg.xml
Crea objetos de tipo Session
#### Session Object
Los objetos de tipo Session nos permiten conectarnos a la BBDD 
para guardar y/o mostrar los objetos del mapeo (CRUD).

Pasos a seguir:
1- Crear Session Factory
2- Crear objeto Session
3- Crear objeto mapeado (en este caso Cliente)
4- Ejecutar transaccion SQL

Una transaccion SQL es un conjunto de instrucciones SQL que se ejecutan todas juntas o no se ejecuta ninguna

Cuando ejecutamos la transsacion SQL:
1- Se ejecuta la transaccion SQL
2- Comenzara la transaccion
3- Guardara el objeto mapeado en la BBDD siempre y cuando se puedan ejecutar todas las sentencias SQL, en caso de que no pueda ejecutar alguna de esas sentencias, se
ejecuta un ROLLBACK y en caso de que todas pudieron ejecutarse se ejecuta un COMMIT
[EXPLICACION ROLLBACK-COMMIT](https://www.youtube.com/watch?v=xiTfest5ApU)   

## Como generar claves primarias

Ej:
@GeneratedValue(strategy=GenerationType.IDENTITY)

- Auto: Selecciona el campo principal en funcion al gestor de bbdd y la estrctura de la tabla.
-Identity: Selecciona un campo en autoincremento.  
- Sequence: Utiliza una secuencia de base de datos para generar valores unicos, mysql no lo admite. 
- Table: Almacena una secuencia de base de datos en una tabla por detras sin que lo veamos deforma transparente. 

## Sentencias SLQ en Hibernate (HQL)

### Errores Leak
Son fugas de memoria, nos indica que el programa esta usando mas memoria de la necesaria y que podria ocasionar un colapso


## FetchType
Especifican como se proporciona la informacion que pedimos a la BBDD

´fetch=FetchType.LAZY/EAGER´

FETCHTYPE POR DEFECTO 

| Relacion | Fetch x defecto |
| :--: | :--: |
| 1a1 | EAGER |
| 1aN | LAZY |
| Na1 |  EAGER |
| NaN | LAZY |

### FetchType.Eager
Devuelve TODA la informacion disponible de una vez.
### FetchType.Lazy
Devuelve la informacion cuando se le pide, solo lo que le pedimos, especifico, ondemand.
