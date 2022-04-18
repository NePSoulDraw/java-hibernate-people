<div class="modal fade" id="addPersonModal" tabindex="-1" aria-labelledby="addPersonModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title" id="addPersonModalLabel">A�adir persona</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletController?action=insert" 
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group mb-2">
                        <label for="name">Nombre</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="surname">Apellido</label>
                        <input type="text" class="form-control" name="surname" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="phone">Tel�fono</label>
                        <input type="number" class="form-control" name="phone" required />
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
                
            </form>
        </div>
    </div>
</div>