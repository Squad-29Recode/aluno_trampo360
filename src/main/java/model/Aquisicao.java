package model;

public class Aquisicao {
	
	private int id_Aquisicao;
	private String data_Aquisicao;
	private String nome;
	private int id_Aluno;
	private int id_Evento;
	private Aluno aluno;
	private Curso evento;

	public Aquisicao() {
	}

	public Aquisicao(int id_Aquisicao, String data_Aquisicao, String nome, int aluno2, int evento2) {
		this.id_Aquisicao = id_Aquisicao;
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Aluno = aluno2;
		this.id_Evento = evento2;
	}


	public Aquisicao(String data_Aquisicao, String nome, int aluno1 , int evento1) {
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Aluno = aluno1;
		this.id_Evento = evento1;
	}

	public Aquisicao(String data_Aquisicao2, String nome2, Aluno aluno1, Evento evento1) {
		// TODO Auto-generated constructor stub
	}

	public Aquisicao(int id_Aquisicao2, String data_Aquisicao2, String nome2, Aluno aluno2, Evento evento2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_Aquisicao() {
		return id_Aquisicao;
	}

	public void setId_Aquisicao(int id_Aquisicao) {
		this.id_Aquisicao = id_Aquisicao;
	}

	public String getdata_Aquisicao() {
		return data_Aquisicao;
	}

	public void setdata_Aquisicao(String data_Aquisicao) {
		this.data_Aquisicao = data_Aquisicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId_Aluno() {
		return id_Aluno;
	}

	public void setId_Aluno (int id_Aluno) {
		this.id_Aluno = id_Aluno;
	}

	public int getid_Evento() {
		return id_Evento;
	}

	public void setid_Evento(int id_Evento) {
		this.id_Evento = id_Evento;
	}
	  

	    

	@Override
	public String toString() {
		return "Aquisicao [id_Aquisicao=" + id_Aquisicao + ", data_Aquisicao=" + data_Aquisicao+ ", nome=" + nome + ", id_Aluno=" + id_Aluno+ ", id_Curso=" + id_Evento+ "]";
	}

	public void setid_Evento(Evento readById) {
		// TODO Auto-generated method stub criado servlet aquisicao
		
	}

	public void setId_Aluno(Aluno readById) {
		// TODO Auto-generated method stub criado servlet aquisicao
		
	}

	}

	

	