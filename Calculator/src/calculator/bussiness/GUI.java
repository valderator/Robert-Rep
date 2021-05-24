package calculator.bussiness;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import calculator.operations.bussiness.Equal;
import calculator.operations.bussiness.EqualRole;
import calculator.operations.bussiness.MinusOperation;
import calculator.operations.bussiness.ModuloOperation;
import calculator.operations.bussiness.MultiplicationOperation;
import calculator.operations.bussiness.OperationRole;
import calculator.operations.bussiness.PlusOperation;

public class GUI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JTextField firstNumber;
	private JTextField secondNumber;
	private JLabel plus;
	private JLabel minus;
	private JLabel multiplication;
	private JLabel modulo;
	private JCheckBox plusCheck;
	private JCheckBox minusCheck;
	private JCheckBox multiplicationCheck;
	private JCheckBox moduloCheck;
	private JButton equal;
	private JLabel result;
	private ArrayList<JCheckBox> cbArray = new ArrayList<JCheckBox>();
	private EqualRole operation;

	public GUI() {

		OperationRole plusOperation = new PlusOperation();
		OperationRole minusOperation = new MinusOperation();
		OperationRole multiplicationOperation = new MultiplicationOperation();
		OperationRole moduloOperation = new ModuloOperation();
		operation = new Equal(null, plusOperation, minusOperation, multiplicationOperation, moduloOperation);

		frame = new JFrame("Arithmetic Calculator");
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(850, 150);

		firstNumber = new JTextField();
		firstNumber.setBounds(10, 26, 200, 20);
		firstNumber.setHorizontalAlignment(0);

		secondNumber = new JTextField();
		secondNumber.setHorizontalAlignment(0);
		secondNumber.setBounds(370, 26, 200, 20);

		plus = new JLabel("Plus");
		plus.setBounds(300, 8, 50, 30);
		minus = new JLabel("Minus");
		minus.setBounds(300, 30, 50, 30);
		multiplication = new JLabel("Multiplication");
		multiplication.setBounds(300, 52, 80, 30);
		modulo = new JLabel("Modulo");
		modulo.setBounds(300, 74, 50, 30);;

		plusCheck = new JCheckBox();
		cbArray.add(plusCheck);
		plusCheck.setBounds(270, 8, 20, 28);
		plusCheck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (JCheckBox jb : cbArray) {
					jb.setSelected(false);
				}

				plusCheck.setSelected(true);
				operation.plus();
			}
		});

		minusCheck = new JCheckBox();
		cbArray.add(minusCheck);
		minusCheck.setBounds(270, 30, 20, 28);
		minusCheck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (JCheckBox jb : cbArray) {
					jb.setSelected(false);
				}

				minusCheck.setSelected(true);
				operation.minus();
			}
		});

		multiplicationCheck = new JCheckBox();
		cbArray.add(multiplicationCheck);
		multiplicationCheck.setBounds(270, 52, 20, 30);
		multiplicationCheck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (JCheckBox jb : cbArray) {
					jb.setSelected(false);
				}

				multiplicationCheck.setSelected(true);
				operation.multiplication();
			}
		});
		
		moduloCheck = new JCheckBox();
		cbArray.add(moduloCheck);
		moduloCheck.setBounds(270, 74, 20, 30);
		moduloCheck.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox jb : cbArray) {
					jb.setSelected(false);
				}

				moduloCheck.setSelected(true);
				operation.modulo();
			}
		});

		equal = new JButton("=");
		equal.setFocusable(false);
		equal.setBounds(600, 20, 50, 30);
		equal.addActionListener(this);

		result = new JLabel("Here is the result!");
		result.setBounds(700, 20, 200, 30);

		panel.add(firstNumber);
		panel.add(secondNumber);
		panel.add(plus);
		panel.add(minus);
		panel.add(multiplication);
		panel.add(modulo);
		panel.add(plusCheck);
		panel.add(minusCheck);
		panel.add(multiplicationCheck);
		panel.add(moduloCheck);
		panel.add(equal);
		panel.add(result);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int equals = operation.compute(Integer.parseInt(firstNumber.getText()),
				Integer.parseInt(secondNumber.getText()));

		result.setText(String.valueOf(equals));
	}

	public static void main(String[] args) {
		new GUI();
	}
}
