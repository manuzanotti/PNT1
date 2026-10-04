
------------------- Parte 1: Preparacion del proyecto -------------------
Proyecto: sistema de gestion de tickets
Nombre: sistema (Le iba a poner sistema de tickets como nombre, pero me trajo problemas.)


------------------- Parte 2: Elegir un Dominio -------------------
Dominio: sistema
Entidades: 
            - Ticket




------------------- Parte 3: Diseñar antes de programar -------------------

Atributos y su tipo de datos:


Id				    long
titulo				String
descripcion			String
prioridad			String
estado			    String
solicitante			String
categoria			String
areaResponsable		String
fechaCreacion		LocalDateTime
fechaCierre         LocalDateTime


Justificación:

    id (Long): Es la clave primaria necesaria para identificar de forma unívoca a cada requerimiento dentro de la base de datos MySQL.

    titulo (String): Permite identificar de manera rápida y resumida la necesidad del usuario sin tener que leer todo el cuerpo del requerimiento.

    descripcion (String): Contiene el detalle completo del problema o la solicitud para que el equipo técnico pueda trabajar en su resolución.

    prioridad (String): Clasifica la urgencia de la atención (ej. ALTA, MEDIA, BAJA), fundamental para medir los acuerdos de nivel de servicio (SLA).

    estado (String): Representa el ciclo de vida del ticket (ej. ABIERTO, EN_PROCESO, RESUELTO, CERRADO), permitiendo llevar el seguimiento de su avance. se inicializa en Abierto

    solicitanteEmail (String): Identifica al usuario que ingresó la solicitud y habilita el uso de validaciones de formato de correo (@Email).

    categoria (String): Agrupa los requerimientos por área temática (ej. Soporte, Desarrollo, Infraestructura) para su correcta asignación.

    areaResponsable (String): Identifica el area responsable de resolver el requerimiento.

    fechaCreacion (LocalDateTime): Registra el momento exacto en que ingresó el ticket, dato clave para auditar el tiempo de respuesta según el SLA.

    fechaCierre (String): Registra el momento de resolución del requerimiento y del ticket mismo, sirve para validar cuanto tiempo demoro la solucion. se inicializa en null


    ¿Hay algún atributo que consideres innecesario? ¿Por qué? 

    Podria quitar titulo ya que en la  descripcion se podria agregar al principio, pero en este caso preferi dejarlo para tener mas datos para trabajar.
    Decidi por ejemplo no poner Pais, que depende del sistema podria ser necesario, pero en este caso vamos a interpretar que por el momento solo se usa en el pais actual.


     ------------------- Parte 4: Base de datos con docker -------------------

    Se realiza la creacion del compose.yaml

    primera salida al ejecutar 

        docker compose up -d
        ✔ Network sistema_default   Created                                                                                                                                                          0.0s
        ✔ Volume sistema_mysql_data Created                                                                                                                                                          0.0s
        ✔ Container sistema         Started   

        docker ps
        CONTAINER ID   IMAGE       COMMAND                  CREATED          STATUS         PORTS                                         NAMES
        0be7ddd4b7ba   mysql:8.4   "docker-entrypoint.s…"   10 seconds ago   Up 8 seconds   0.0.0.0:3306->3306/tcp, [::]:3306->3306/tcp   sistema

        


             ------------------- Parte 5: Configuracion de Spring Boot -------------------

             Configuracion actual:
                spring.datasource.url=jdbc:mysql://localhost:3306/sistema?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
                spring.datasource.username=root
                spring.datasource.password=root

                spring.jpa.hibernate.ddl-auto=update
                spring.jpa.show-sql=true

                server.port=8080


            Tema contraseñas queda pendiende a ocultarlas.




            ------------------- Parte 6: Crear la entidad -------------------

            Se crea la carpeta model y la clase Ticket.java para representar la entidad
            A ticket se le asignan los siguientes datos y sus valores.
            Id				    long
            titulo				String
            descripcion			String
            prioridad			String
            estado			    String
            solicitante			String
            categoria			String
            areaResponsable		String
            fechaCreacion		LocalDateTime
            fechaCierre         LocalDateTime



            ¿Por qué esta clase representa una entidad?
            Porque está anotada con @Entity de Jakarta Persistence (JPA). Esto le indica al ORM (Hibernate) 
            que esta clase Java debe mapearse a una tabla persistente en la base de datos MySQL. 
            Cada instancia (objeto) de Ticket representará un registro único (fila) persistido en la tabla.
            
            ¿Qué atributo funciona como identificador?
            El atributo id anotado con @Id. Además, utiliza @GeneratedValue(strategy = GenerationType.IDENTITY), 
            lo que especifica que la clave primaria es auto-incremental y delegada a la base de datos MySQL (AUTO_INCREMENT).
            
            ¿Qué relación existe entre esta clase Java y una tabla de la base de datos?
            Existe una relación de mapeo objeto-relacional (ORM) de 1 a 1:
            La clase Ticket se mapea a la tabla ticket (o tickets) en MySQL.
            Cada atributo de la clase (como titulo, descripcion, fechaCreacion) se mapea a una columna de dicha tabla.
            Cada instancia del objeto Ticket corresponde a una fila (registro) dentro de la tabla.






                        ------------------- Parte 7: Crear el Repository -------------------
                        ¿Qué problema nos evita resolver JpaRepository?
                       Nos evita tener que escribir las consultas basicas a mano, utilizando operaciones de persistencia.