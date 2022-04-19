
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar persona</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/components/commons/header.jsp" />
        
        <jsp:include page="/WEB-INF/components/commons/editButtons.jsp" />
        
        <form action="${pageContext.request.contextPath}/ServletController?action=modify&personId=${person.personId}"
              method="POST" class="was-validated">

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">

                                    <h4>Editar persona</h4>

                                </div>
                                <div class="card-body">

                                    <div class="form-group mb-2">
                                        <label for="name">Nombre</label>
                                        <input type="text" class="form-control" name="name" required value="${person.name}"/>
                                    </div>

                                    <div class="form-group mb-2">
                                        <label for="surname">Apellido</label>
                                        <input type="text" class="form-control" name="surname" required value="${person.surname}"/>
                                    </div>

                                    <div class="form-group mb-2">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" name="email" required value="${person.email}"/>
                                    </div>

                                    <div class="form-group mb-2">
                                        <label for="phone">Teléfono</label>
                                        <input type="number" class="form-control" name="phone" required value="${person.phone}"/>
                                    </div>

                                    <button class="btn btn-primary text-white my-3" type="submit">Guardar cambios</button>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                                    
        </form>
        
        <jsp:include page="/WEB-INF/components/commons/footer.jsp" />
                                    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        
    </body>
</html>