package dss;

public class CadenaFiltros {
    private // declarar: filtros es un Array List generico de elementos Filtro

    private Interfaz objetivo ;

    public void addFiltro(Filtro filtro){
        filtros.add(filtro);
    }

    public void ejecutar(double peticion){
        for(Filtro filtro: filtros){
            System.out.println(”Nueva velocidad(m/s)”+ filtro.ejecutar(peticion))
        }
        objetivo.ejecutar(peticion);
    }

    public void setObjetivo(Interfaz objetivo){
        this.objetivo = objetivo ;
    }
}