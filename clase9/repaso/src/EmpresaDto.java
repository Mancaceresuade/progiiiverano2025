public class EmpresaDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmpresaDto(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmpresaDto [id=" + id + "]";
    }
    
    
}
