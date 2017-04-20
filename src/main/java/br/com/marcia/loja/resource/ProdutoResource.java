package br.com.marcia.loja.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcia.loja.model.Produto;
import br.com.marcia.loja.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Inserir um ou mais produtos.
	 * @param produtosParam
	 * @return
	 */
	  @RequestMapping(value = "/insere", method = RequestMethod.POST)
	  public ResponseEntity<Produto> inserir(@RequestBody List<Produto> produtosParam) {
		  
		  for (Iterator<Produto> iterator = produtosParam.iterator(); iterator.hasNext();) {
			Produto produtoInserir = (Produto) iterator.next();
			  Produto p = new Produto();
			  p.setAtivo(produtoInserir.getAtivo());
			  p.setCaixaPadrao(produtoInserir.getCaixaPadrao());
			  p.setCodigo(produtoInserir.getCodigo());
			  p.setEan(produtoInserir.getEan());
			  p.setNcm(produtoInserir.getNcm());		  
			  p.setNomenclatura(produtoInserir.getNomenclatura());
			  p.setSal(produtoInserir.getSal());
			  p.setPreco(produtoInserir.getPreco());
			  produtoRepository.save(p);
			
		}
		  return new ResponseEntity<Produto>(HttpStatus.OK);
	  }	
	  
	  
	  /**
	   * Alterar o preço de um ou mais produtos.
	   * @param produtosParam: uma lista de Produto com apenas os atributos produtoId e preco preenchidos.
	   * @return
	   */
	  @RequestMapping(value = "/alterarPreco", method = RequestMethod.PUT)
	  public ResponseEntity<Produto> alterarPreco(@RequestBody List<Produto> produtosParam) {
		  
		  for (Iterator<Produto> iterator = produtosParam.iterator(); iterator.hasNext();) {
			  Produto produtoAlterar = (Produto) iterator.next();
			  
			  Produto p = produtoRepository.getOne(produtoAlterar.getProdutoId());
			  p.setPreco(produtoAlterar.getPreco());
			  produtoRepository.save(p);			
		  }
		  
		  return new ResponseEntity<Produto>(HttpStatus.OK);
	  }	
	  
	  
	  /**
	   * Buscar todos os produtos cadastrados.
	   * @return
	   */
	  @RequestMapping(value = "/listar", method = RequestMethod.GET)
	  public ResponseEntity<List<Produto>> listar() {
		  List<Produto> produtos = produtoRepository.findAll();		  
		  return new ResponseEntity<List<Produto>>(new ArrayList<Produto>(produtos), HttpStatus.OK);
	  }
	  	  
}
