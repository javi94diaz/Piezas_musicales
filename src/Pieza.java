package partituras2;

public class Pieza {
    private String nombre;
    private String compositor;
    private String tonalidad;
    private int nivel;
    private int compases;
    private String ArmaduraDeClave;
    private String nombreImagen;
    private String audio;

    public Pieza(String nombre, String compositor, String tonalidad, int nivel, int compases, String ArmaduraDeClave, String nombreImagen, String audio){
        this.nombre = nombre;
        this.compositor = compositor;
        this.tonalidad = tonalidad;
        this.nivel = nivel;
        this.compases = compases;
        this.ArmaduraDeClave = ArmaduraDeClave;
        this.nombreImagen = nombreImagen;
        this.audio = audio;
    }

    public Pieza() {
        nombre = "desconocido";
        compositor = "desconocido";
        tonalidad = "desconocido";
        nivel = 0;
        compases = 0;
        ArmaduraDeClave = "desconocido";
        nombreImagen = "desconocido";
        audio = "desconocido";
    }

    // crear metodo toFile en la clase pieza que la grabe en un fichero de texto
	// y otro metodo fromFile que lea una linea del fichero y reconstruya un objeto de la clase pieza
	
	
    
    
    //Setters

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetCompositor(String compositor) {
        this.compositor = compositor;
    }

    public void SetTonalidad(String tonalidad) {
        this.tonalidad = tonalidad;
    }

    public void SetArmaduraDeClave(String ArmaduraDeClave) {
        this.ArmaduraDeClave = ArmaduraDeClave;
    }

    public void SetCompases(int compases) {
        this.compases = compases;
    }
    public void SetNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void SetNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
    
    public void SetAudio(String audio) {
        this.audio = audio;
    }

    // Getters
    
    public String getNombre() {
        return nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public String getTonalidad() {
        return tonalidad;
    }

    public String getArmaduraDeClave() {
        return ArmaduraDeClave;
    }

    public int getCompases() {
        return compases;
    }

    public int getNivel() {
        return nivel;
    }
    
    public String getNombreImagen() {
        return nombreImagen;
    }
    
    public String getAudio() {
        return audio;
    }

    public String getStringPieza () {
        String mensaje = "Info de la pieza: \n";
        mensaje = mensaje + "Nombre: " + this.getNombre()+"\n";
        mensaje = mensaje + "Compositor: " + this.getCompositor() + "\n";
        mensaje = mensaje + "Tonalidad: " + this.getTonalidad() + "\n";
        mensaje = mensaje + "Armadura de clave: " + this.getArmaduraDeClave() + "\n";
        mensaje = mensaje + "Compases: " + this.getCompases() + "\n";
        mensaje = mensaje + "Nivel: " + this.getNivel() + "\n";
        return mensaje;
    }

}


