term = "Price elasticity of demand ($E_d$)"
text = ""
copy = True
if ["(",")"] in term:
  for i in range(0, term.length()):
    if term[i] == "(" & copy:
      copy = False
      continue
    else if term[i] == ")" & !copy:
      copy = True
      continue
    if copy:
      text += term[i]

print(term)
