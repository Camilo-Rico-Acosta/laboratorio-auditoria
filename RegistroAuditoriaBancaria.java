public class RegistroAuditoriaBancaria implements AutoCloseable {

    private boolean abierto;

    public RegistroAuditoriaBancaria() {
        abierto = true;
        System.out.println("Registro de auditoría bancaria abierto.");
    }

    public void registrar(String mensaje) {
        if (abierto) {
            System.out.println("[LOG BANCARIO] " + mensaje);
        } else {
            System.out.println("El registro está cerrado.");
        }
    }

    @Override public void close() {
        abierto = false;
        System.out.println("Registro de auditoría bancaria cerrado.");
    }
}