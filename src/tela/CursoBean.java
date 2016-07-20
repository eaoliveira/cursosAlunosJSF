package tela;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.CursoDao;
import modelo.Curso;

@ManagedBean
public class CursoBean {
	@EJB
	private CursoDao dao;
	private String nome;
	private String desc;
	private String data;
	private String horas;
	private Integer curso;
	
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	
	
	public List<Curso> getCursos(){
		return dao.getCursos();
	}
	

	public void salvar(){
		Curso obj=new Curso();
		obj.setNome(nome);
		obj.setDescr(desc);
		obj.setHoras(horas);
		obj.setInicio(data);
		dao.adiciona(obj);
		FacesMessage msg = new FacesMessage("Curso Cadastrado");
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("form1", msg);
	}

}