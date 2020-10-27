* annotated_score:
	- 1: don’t know
	- 2: secure
	- 3: somewhat secure
	- 4: insecure
	- 5: ambiguous 

* predicted_score
	- -1: secure (equals annotated_score 2,3,5)
	-  1: insecure (equals annotated_score 4)

* snippetid
	- {0,…, n-1} where n is the number of code snippets per post id.

* table schemes 
	- question_snippets: snippet text, hash text
	- question_snippets.predicts: hash text, predicted_score int
	- questions_snippets_found.predicts: hash text, predicted_score int
	- answer_snippets.annotations: snippet text, annotated_score int, snippetid int, hash text
	- answer_snippets.predicts: hash text, predicted_score int
	- answer_snippets_found.predicts: hash text, predicted_score int

