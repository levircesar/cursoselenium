import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	@Test
	public void deveCadastrarUmUsuario() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(768,450));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Levir");
		Assert.assertEquals("Levir", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		//sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lemos");
		Assert.assertEquals("Lemos", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		//sexo
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		//comida
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	
		//escolaridade
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	
		//esportes
		element = driver.findElement(By.id("elementosForm:esportes"));
		combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		//sugestoes
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Melhorias");
		Assert.assertEquals("Melhorias", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//cadastrar button
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
	}
}
