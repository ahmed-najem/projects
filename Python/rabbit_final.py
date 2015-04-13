#rabbit_final.py

def answer(names):
	names.sort(reverse=True)
	names.sort(key=ord_sorter, reverse=True)
	return names
	
def ord_sorter(string):
	return sum(ord(char) - 96 for char in string.lower())
	