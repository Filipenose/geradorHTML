package geradorHTML;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GerarHTML {
	
	
	
	public static void main( String[] args ) throws Exception {
		String[] cabecalho = { "nome", "Telefone", "Endereco" };
		String[][] dados = { 
							{ "Msrcus", "71986874997", "Rua D Chapeu" }, 
							{ "Thiago","7199889832", "Pituba"}, 
							{ "Filipe", "232424", "Castelo Branco" } };
		gerarHTML( "Checklist", "Projeto 8890", cabecalho, dados);
	}

	public static String getCabecalhoHTML( String[] cabecalho ) {
		StringBuilder html = new StringBuilder();
		int i=0;
		html.append("<tr>");
		for (i = 0; i < cabecalho.length; i++) {
			html.append("<th align='center'><b>" + cabecalho[i].toUpperCase() + "</b></th>");
		}
		html.append("</tr>");
		return html.toString();
	}
	
	public static String getFooterHTML( String copyright ) {
		
		StringBuilder html = new StringBuilder();
		html.append( "<footer id=\"footer\" class=\"grid-block\">" );
		html.append( "	<div class=\"module   deepest\">" );
		html.append( "		<p style=\"text-align: center;\">" + copyright + "&nbsp;\r\n </p>" );
		html.append( "	</div>" );
		html.append( "</footer>");
		
		return html.toString();
		
	}
	
	public static String getDadosHTML(String[][] dados) throws Exception {
		StringBuilder html = new StringBuilder();
		int linha = -1;
		int coluna = -1;
		try {
			for(linha = 0; linha < dados.length; linha++ ) {
				html.append("<tr>");
				for( coluna=0; coluna < dados[linha].length; coluna++ ) {
					html.append("<td align='left'>" + dados[linha][coluna] + "</td>");
				}
				html.append("</tr>");
			}
			return html.toString();
		}catch( Exception e ){
			throw new Exception( "Erro ao chamar getDadosHTML(). Linha '" + linha + "' e coluna '" + coluna + "'." );
		}
	}
	
	public static String getLogoEstaticoHTML(String urlHref, String urlImagem) {
		String enderecoWEBTeste = "https://www.w3schools.com";
		String enderecoWEBLogoTeste = ("https://bit.ly/2IW7zGR");
		StringBuilder html = new StringBuilder();
				html.append( "<div align='center' class='gwd-div-1hvb'>" );
				html.append( "<header>" );
				html.append( "<a href="+ enderecoWEBTeste + ">" );
				html.append( "<div>" );
				html.append( "<img align='center' border='0' src=" + enderecoWEBLogoTeste );
				html.append( " class='gwd-img-183s' ");
				html.append( "width='196' heigth='70' alt='logo brisa' ");
				html.append( "style='margin: 0px; border: 0px; none rgb(0, 0, 0); float:center;'>" );
				html.append( "</div>" );
				html.append( "</a>" );
				html.append( "</herader>" );
				html.append( "</div><br>" );
				html.append( "<br>" );
				
				return html.toString();
		
		
	}
	
	public static void gerarHTML(String titulo, String descricaoTabela, String[] cabecalho, String[][] dados) throws Exception {
		
		try {

			FileWriter arq =  new FileWriter("f:\\teste5.html");
			PrintWriter gravarArq =  new PrintWriter(arq);
			StringBuilder html = new StringBuilder();
			
			if ( cabecalho != null && dados != null ) {
				
				html.append("<!DOCTYPE html>");
				html.append("<html>");
				html.append("<head>");
				html.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
				html.append("<meta charset='utf-8'>");
				html.append("<title>Gerador de HTML</title>");
				html.append("<meta name='generator' content='Google Web Designer 5.0.4.0226'>");
				html.append("</head>");
				html.append("<body class htmlNoPages>");
				html.append( getLogoEstaticoHTML("https://www.w3schools.com", "https://bit.ly/2IW7zGR" ));
				html.append("<div class='container'>");
				html.append("<h2>" + titulo + "</h2><br>");
				html.append("<p>" + descricaoTabela + "<p><br>");
				html.append("<table class='table'>");
				html.append("<tbody>");
				html.append( getCabecalhoHTML( cabecalho ) );
				html.append( getDadosHTML(dados));
				html.append("</tbody>");
				html.append("</table>");
				html.append("</div>");
				html.append("</body>");
				html.append( getFooterHTML( "Copyright @ 2013. Todos os direitos reservados." ) );
				gravarArq.print(html.append("</html>"));

				System.out.println( html.toString() );
				
				gravarArq.close();
				
			}else {
				throw new Exception("O array e a matriz est�o vazios. ");
			}
			
		} catch (Exception e) {			
			throw new Exception( "Erro ao gerar o HTML. " + e.getMessage() );
		}

	}
}
