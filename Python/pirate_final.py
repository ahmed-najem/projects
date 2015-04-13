#pirate_final.py

def answers(numbers):
	flag = False
	index = 0
	visited = []
	start_index = 0
	
	#Find loop start
	while flag == False:
		if index in visited:
			start_index = numbers[index]
			flag = True
		else:
			visited.extend([index])
			index = numbers[index]
	
	#Count loop members
	index = start_index
	flag = False
	visited = []
	
	while flag == False:
		if index in visited:
			flag = True
		else:
			visited.extend([index])
			index = numbers[index]

	return len(visited)
