#include <iostream>
//#include<cstdio>
#include<string>
#include"Tree.cpp"

void showTitle() {
	cout <<"Binary search tree\n" << "--------------------\n";
}

void showOptions() {
	cout << "Press:\n"
		<< "1. Search\n"
		<< "2. Insert\n"
		<< "3. Delete\n"
		<< "4. Close program\n";
}

int chooseType() {
	char key;
	do {
		system("clear");
		showTitle();
		cout << "Choose type:\n"
			<< "1. Integer\n"
			<< "2. Double\n"
			<< "3. String\n";
		cin.get(key);
	} while (key != '1' && key != '2' && key != '3');

	return (int)(key) - 48;
}

int getInt() {
	string newInt;
	cout << "Value : ";
	cin >> newInt;
	return stoi(newInt);
}

double getDouble() {
	string newDouble;
	cout << "Value : ";
	cin >> newDouble;
	return stod(newDouble);
}

string getString() {
	string newString;
	cout << "Value : ";
	cin >> newString;
	return newString;
}

int main() {
	char key;
	string info = "";

	int typeNumber = chooseType();

	if (typeNumber == 1) {
		Tree<int>* tree = new Tree<int>();

		do {
			system("clear");
			showTitle();
			tree->draw();
			cout << info << "\n";
			showOptions();
			cin.get(key);

			int number = (int)(key) - 48;

			if (number == 1) {
				try {
					int value = getInt();
					tree->searchElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			} else if (number == 2) {
				try {
					int value = getInt();
					tree->insertElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			} else if (number == 3) {
				try {
					int value = getInt();
					tree->deleteElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			}

		} while (key != '4');
	
	} else if (typeNumber == 2) {
		Tree<double>* tree = new Tree<double>();

		do {
			system("clear");
			showTitle();
			tree->draw();
			cout << info << "\n";
			showOptions();
			cin.get(key);

			int number = (int)(key) - 48;

			if (number == 1) {
				try {
					double value = getDouble();
					tree->searchElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			} else if (number == 2) {
				try {
					double value = getDouble();
					tree->insertElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			} else if (number == 3) {
				try {
					double value = getDouble();
					tree->deleteElement(value);
					info = "";
				} catch (...) {
					info = "Wrong element";
				}
			}

		} while (key != '4');
	} else if (typeNumber == 3) {
		Tree<string>* tree = new Tree<string>();

		do {
			system("clear");
			showTitle();
			tree->draw();
			showOptions();
			cin.get(key);

			int number = (int)(key) - 48;

			if (number == 1) {
				string value = getString();
				tree->searchElement(value);
			} else if (number == 2) {
				string value = getString();
				tree->insertElement(value);
			} else if (number == 3) {
				string value = getString();
				tree->deleteElement(value);
			}

		} while (key != '4');
	}

	return 0;
}