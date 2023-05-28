# SI_2023_lab2_216005
Бојан Велкоски 216005

2. CFG - Направен
3. Цикломатска комплексност: Е - број на ребра V - број на јазли
	Број на региони е 11
	E=31 V=22
	G=E-V+2
	G=31-22+2=11
4. Тест случаи според критериумот Every Branch:
	1* user=null, allUsers=anything
	2* user={null, pass, abc@.com}, allUsers={User[0]={abc, password, abc@.com}, User[1]={Joe, password, Joe@.com}
	3* user={Bojan, Proekt 123, Bvelkoski3@.com}, allUsers=emptyList
	4* user={Bojan, Proekt123, Bvelkoski3@.com}, allUsers=emptyList
	5* user={Bojan, Proekt123!, Bvelkoski3@.com}, allUsers=emptyList
-Објаснети се во excel документот со име "SILab2EveryBranch"

5. Тест случаи според критериумот Multiple Condition се:
if (user == null || user.getPassword() == null || user.getEmail() == null)
	T || X || X
	{User(null, null, null), emptyList} 
	F || T || X
	{User("Bojan", null, null), emptyList}
	F || F || T
	{User("Bojan", "proekt123!", null), emptyList}
	F || F || F
	{User("Bojan", "proekt123!", "bvelkoski3@.com"), emptyList}
-Имплементирани во јава проектот
6. Done