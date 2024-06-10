package com.generation.farmacia.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo de nome é Obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no minimo 3 e no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo de foto é Obrigatório!")
	@Size(min = 3, max = 5000, message = "O atributo foto deve conter no minimo 3 e no máximo 5000 caracteres")
	private String foto;
	
	@NotBlank(message = "O atributo de descrição é Obrigatório!")
	@Size(min = 3, max = 1000, message = "O atributo descrição deve conter no minimo 3 e no máximo 1000 caracteres")
	private String descricao;
	
	@NotNull(message = "O atributo preço é Obrigatório!")
	@PositiveOrZero(message = "O atributo valor deve ser no minimo igual ou maior que zero!")
	private float preco;
	
	@UpdateTimestamp
	private LocalDateTime dataEntrada;
	
	@ManyToOne
    @JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
