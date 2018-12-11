package com.stackroute.datamunger.reader;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Pattern;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
//import com.sun.org.apache.xpath.internal.operations.String;

public class CsvQueryProcessor extends QueryProcessingEngine {


	static String fileName = new String();
	// Parameterized constructor to initialize filename

	public static void readFile() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		// ...
	}
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {

		this.fileName = fileName;
		readFile();

		//throws FileNotFoundException;

	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException {
		String line = new String();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(this.fileName));
			//line = reader.readLine();
			line = reader.readLine();
			reader.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Header header = new Header();
		String[] headers;
		headers = line.split(",");
		//System.out.println(headers.length);
		//List<String> headers1 = new ArrayList<>();
		header.setHeader(headers);
		//System.out.println(header.getHeaders());
		return header;

	}
	

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
	 */

    private static Pattern DATE_PATTERN_1 = Pattern.compile(
            "^\\d{4}-\\d{2}-\\d{2}$");

    private static Pattern DATE_PATTERN_2 = Pattern.compile(
            "^\\d{2}-\\d{3}-\\d{4}$");

    private static Pattern DATE_PATTERN_3 = Pattern.compile(
            "^\\d{2}-\\d{3}-\\d{2}$");

    private static Pattern DATE_PATTERN_4 = Pattern.compile(
            "^\\d{2}/\\d{2}/\\d{4}$");

    private static Pattern DATE_PATTERN_5 = Pattern.compile(
            "^\\d{2}-\\d{2}-\\d{4}$");


	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
        String line = new String();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.fileName));
            //line = reader.readLine();
            //line = reader.readLine();

            for(int i=0;i<2;i++)
            {
                line = reader.readLine();
            }
            //line = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Scanner scanner = new Scanner(fileName);
        DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions();
        List<String> dataType = new ArrayList();
        String[] data = line.split(",",-1);
        //System.out.println("sfdnjdbfjs" + data[17] + "dsfhdsfbhej");
        for(int i=0;i<data.length;i++)
        {
            Pattern pattern = Pattern.compile(".*\\D.*");
            //Pattern pattern1 = Pattern.compile(".*\\-*")


            if(data[i].equals(""))
                dataType.add("java.lang.Object");
            else if(DATE_PATTERN_4.matcher(data[i]).matches())
                dataType.add("java.util.Date");
            else if(DATE_PATTERN_3.matcher(data[i]).matches())
                dataType.add("java.util.Date");
            else if(DATE_PATTERN_2.matcher(data[i]).matches())
                dataType.add("java.util.Date");
            else if(DATE_PATTERN_1.matcher(data[i]).matches())
                dataType.add("java.util.Date");
            else if(!pattern.matcher(data[i]).matches())
                dataType.add("java.lang.Integer");
            else
                dataType.add("java.lang.String");
        }

        String[] arr = new String[dataType.size()];

        // ArrayList to Array Conversion
        for (int i =0; i < dataType.size(); i++)
            arr[i] = dataType.get(i);

        dataTypeDefinitions.setDataTypes(arr);
        return dataTypeDefinitions;


		// TODO Auto-generated method stub
		
		// checking for Integer
		
		// checking for floating point numbers
				
		// checking for date format dd/mm/yyyy
		
		// checking for date format mm/dd/yyyy
		
		// checking for date format dd-mon-yy
		
		// checking for date format dd-mon-yyyy
		
		// checking for date format dd-month-yy
		
		// checking for date format dd-month-yyyy
		
		// checking for date format yyyy-mm-dd

	}
	
	

	
	

}
