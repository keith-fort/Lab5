package prod.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import prod.baseClasses.Coordinates;
import prod.baseClasses.Location;
import prod.baseClasses.Route;

public class FileManager {												

	String filePath;
	
	public FileManager(String filePath) {
		this.filePath = filePath;
	}
	
	public void printFile() {
		// Укажите путь к CSV-файлу

        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Читаем файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Разделяем строку на значения с помощью split()
                String[] values = line.split(",");

                // Выводим значения
                for (String value : values) {
                    System.out.print(value + " | ");
                }
                System.out.println(); // Переход на новую строку
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        
	}

	/*
	public void loadToCollection(LinkedList<Route> collection) {
		
		// Укажите путь к CSV-файлу

        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Читаем файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Разделяем строку на значения с помощью split()
                String[] values = line.split(",");

                // Выводим значения
//                for (String value : values) {}
                
                System.out.print(values[0] + " ");
                System.out.print(values[1] + " ");
                System.out.print("(" + values[2] + " ");
                System.out.print(values[3] + ")" + " ");
                System.out.print(values[4] + " ");
                System.out.print("(" + values[5] + " ");
                System.out.print(values[6] + " ");
                System.out.print(values[7] + ")" + " ");
                System.out.print("(" + values[8] + " ");
                System.out.print(values[9] + " ");
                System.out.print(values[10] + ")" + " ");
                System.out.print(values[11] + " ");
                                               
                System.out.println(); // Переход на новую строку(нужен ли?)
                
                //collection.add(new Route(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]));
                collection.add(null)
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
		
	} */
	
	public void loadToCollection(LinkedList<Route> collection) {
		
		try (Scanner scanner = new Scanner(new File(filePath))) {
            // Пропускаем заголовок
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Читаем каждую строку файла
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                // Парсим поля
                Long id = Long.parseLong(fields[0]);
                String name = fields[1];
                float coordinatesX = Float.parseFloat(fields[2]);
                float coordinatesY = Float.parseFloat(fields[3]);
                long creationDateMillis = Long.parseLong(fields[4]);
                Integer fromX = Integer.parseInt(fields[5]);
                int fromY = Integer.parseInt(fields[6]);
                String fromName = fields[7];
                Integer toX = Integer.parseInt(fields[8]);
                int toY = Integer.parseInt(fields[9]);
                String toName = fields[10];
                Integer distance = Integer.parseInt(fields[11]);

                // Создаем объекты Coordinates, Location и Route
                Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY);
                Location from = new Location(fromX, fromY, fromName);
                Location to = new Location(toX, toY, toName);
                Date creationDate = new Date(creationDateMillis);

                Route route = new Route(id, name, coordinates, creationDate, from, to, distance);

                // Добавляем объект Route в коллекцию
                collection.add(route);
            }

            System.out.println("Данные успешно загружены из CSV-файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
		
	}

	public void loadToCSV(LinkedList<Route> collection) {
		
		// Записываем данные в CSV-файл с использованием FileOutputStream
        try (FileOutputStream fos = new FileOutputStream("routes.csv")) {
            // Заголовок CSV
            String header = "id,name,coordinates_x,coordinates_y,creationDate,from_x,from_y,from_name,to_x,to_y,to_name,distance\n";
            fos.write(header.getBytes());

            // Записываем каждый объект Route
            for (Route route : collection) {
                String line = route.toString2() + "\n";
                fos.write(line.getBytes());
            }

            System.out.println("CSV-файл успешно создан.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
		
	}
	
}
