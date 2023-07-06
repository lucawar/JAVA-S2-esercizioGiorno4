package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainEsercizio {

	public static void main(String[] args) {

//-------------------------------------------------------------ESERCIZIO 1-----------------------------------------------------------------------
		List<Product> products = new ArrayList<>();
		Random rndm = new Random();
		products.add(new Product(rndm.nextLong(), "HARRY POTTER", "Books", 150));
		products.add(new Product(rndm.nextLong(), "THE WITCHER", "Books", 120));
		products.add(new Product(rndm.nextLong(), "IL CODICE DA VINCI", "Books", 50));

		List<Product> filtraProdotti = products.stream().filter(b -> b.getCategory().equals("Books"))
				.filter(b -> b.getPrice() > 100).collect(Collectors.toList());

		System.out.println("ESERCIZIO 1");
		System.out.println("");

		for (Product prodotti : filtraProdotti) {
			System.out.println("Libro" + " : " + prodotti.getId() + " : " + prodotti.getName() + " : "
					+ " il suo prezzo è: " + prodotti.getPrice());

			System.out.println("-------------------------------------------------------------------------------");
		}

//-------------------------------------------------------------ESERCIZIO 2-----------------------------------------------------------------------
		System.out.println("");
		System.out.println("ESERCIZIO 2");
		System.out.println("");
		List<Product> babyProducts = new ArrayList<>();
		babyProducts.add(new Product(rndm.nextLong(), "BIBERON", "Baby", 10));
		babyProducts.add(new Product(rndm.nextLong(), "PANNOLINI", "Baby", 20));
		babyProducts.add(new Product(rndm.nextLong(), "OMOGENIZZATI", "Baby", 15));

		Customer cliente = new Customer(rndm.nextLong(), "Luca", 1);

		List<Order> ordini = new ArrayList<>();
		ordini.add(new Order(rndm.nextLong(), "SPEDITO", LocalDate.now(), LocalDate.now().minusDays(4), "Baby",
				babyProducts, cliente));

		List<Order> filtraOrdini = ordini.stream()
				.filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Baby")))
				.collect(Collectors.toList());

		for (Order ord : filtraOrdini) {
			System.out.println("ORDINE ID: " + ord.getId());
			System.out.println("CATEGORIA: " + ord.getCategory());
			System.out.println("DATA DI OGGI: " + ord.getOrderDate());
			System.out.println("STATO SPEDIZIONE: " + ord.getStatus());
			System.out.println("DATA SPEDIZIONE: " + ord.getDeliveryDate());

		}

//-------------------------------------------------------------ESERCIZIO 3-----------------------------------------------------------------------

		System.out.println("");
		System.out.println("ESERCIZIO 3");
		System.out.println("");
		List<Product> boysProducts = new ArrayList<>();
		boysProducts.add(new Product(rndm.nextLong(), "COMPUTER", "Boys", 700));
		boysProducts.add(new Product(rndm.nextLong(), "TELEVISORE", "Boys", 800));
		boysProducts.add(new Product(rndm.nextLong(), "CELLULARE", "Boys", 500));

		List<Product> filtraProdottiBoys = boysProducts.stream().filter(b -> b.getCategory().equals("Boys")).map(b -> {
			double sconto = b.getPrice() * 0.9;
			b.setPrice(sconto);
			return b;
		}).collect(Collectors.toList());

		for (Product prodotto : filtraProdottiBoys) {
			System.out.println("PRODOTTO: " + prodotto.getName());
			System.out.println("NUMERO ID: " + prodotto.getId());
			System.out.println("CATEGORIA: " + prodotto.getCategory());
			System.out.println("PREZZO: " + prodotto.getPrice() / 0.9);
			System.out.println("PREZZO SCONTATO: " + prodotto.getPrice());
			System.out.println("--------------------------------");
		}

//-------------------------------------------------------------ESERCIZIO 4-----------------------------------------------------------------------		

		System.out.println("");
		System.out.println("ESERCIZIO 4");
		System.out.println("");
	}
}
