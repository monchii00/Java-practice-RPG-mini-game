Personal mini-project built to practice core Java and Object-Oriented Programming (OOP) concepts hands-on.

The code in this repository was built by following a structured, step-by-step RPG blueprint generated with Claude (included below).







"Mini Quest" — A One-Evening Text RPG Blueprint

This is a class-by-class blueprint, not code. Read it top to bottom — each class introduces exactly one new OOP idea, building on the one before it. By the last class, you'll have touched every major concept in a small, playable game.

Scope: One hero, two monster types, one item, one weapon, one battle. That's it. Resist the urge to add more until it's working.

Learning Path (read in this order)
Order	Class	New Concept Introduced
1	Item	Classes, Objects, Constructors
2	Weapon	Encapsulation (private fields + getters/setters)
3	Character	Abstraction (abstract class, shared blueprint)
4	Hero	Inheritance + Composition (HAS-A Weapon/Inventory)
5	Monster	Inheritance (a second subclass)
6	Goblin / Dragon	Polymorphism (overriding + dynamic binding)
7	Inventory	Composition/Aggregation (holds many Items)
8	Game Controller	Everything working together in a loop
Class 1 — Item

OOP Concept: Classes, Objects, and Constructors (the absolute basics)

Role / Description:
Represents any pickup-able thing in the game world — a potion, a coin, a key. This is your simplest possible class, just to practice the idea of "a blueprint that becomes real objects."

Properties (Fields):

Name — private — what the item is called (e.g., "Health Potion")
Description — private — a short flavor line
Value — private — how much it's worth (a number)

Methods (Actions):

Constructor — takes in: a name (text), a description (text), and a value (whole number) — returns: nothing, it builds one item object
Get Name — takes in: nothing — returns: the item's name (text)
Get Description — takes in: nothing — returns: the item's description (text)
Get Value — takes in: nothing — returns: the item's value (whole number)

Connections:

Standalone for now. Later, Inventory will hold a collection of these.

✅ Done when: You can create one Item object by feeding it a name, description, and value, then successfully print each of those three pieces of information back out by calling its getter methods. If you can make a "Health Potion" object and print its name, description, and value separately, move on.

Class 2 — Weapon

OOP Concept: Encapsulation (private fields, controlled access via getters/setters)

Role / Description:
Something a Hero equips to fight with. This class is where you deliberately practice "hiding" data and only exposing it through methods — the core discipline of encapsulation.

Properties (Fields):

Name — private — e.g., "Rusty Sword"
Damage — private — a number representing how hard it hits

Methods (Actions):

Constructor — takes in: a name (text) and a damage value (whole number) — returns: nothing, it builds one weapon
Get Name — takes in: nothing — returns: the weapon's name (text)
Get Damage — takes in: nothing — returns: the damage number (whole number)
Set Damage — takes in: a new damage value (whole number) — returns: nothing, it just updates the damage field internally (this is your practice "setter" — maybe used later for a weapon upgrade)

Connections:

Will be HAS-A'd (contained) by Hero. A Hero doesn't extend Weapon — it owns one.

✅ Done when: You can create one Weapon object, read its name and damage back out, and then successfully change its damage using the setter and confirm (by calling the getter again) that the new value stuck. If changing the damage after creation works, move on.

Class 3 — Character

OOP Concept: Abstraction (an abstract base class — a shared blueprint that's never used directly)

Role / Description:
The shared foundation for anything that can fight: name, health, and the general shape of "a living thing in this game." You will never create a plain Character object directly — it only exists so Hero and Monster can inherit from it. This is the "abstract" idea: a concept too general to stand alone.

Properties (Fields):

Name — private — shared by every character
Health — private — a number, shared by every character
Attack Power — private — a baseline number, shared by every character

Methods (Actions):

Constructor — takes in: a name (text), starting health (whole number), and attack power (whole number) — returns: nothing, it sets up the shared data
Get Name — takes in: nothing — returns: the name (text)
Get Health — takes in: nothing — returns: current health (whole number)
Take Damage — takes in: a damage amount (whole number) — returns: nothing, it reduces health internally
Is Alive — takes in: nothing — returns: true or false, based on whether health is above zero
Attack (abstract/undefined here) — takes in: nothing decided yet — returns: nothing decided yet; declared as "every Character must be able to attack," but how they attack is left blank on purpose. Each subclass will fill this in differently. This is the seed that makes polymorphism possible later.

Connections:

This is the base class. Hero and Monster will both say "I AM-A Character."
Cannot be turned into an object on its own — it's a template, not a finished thing.

✅ Done when: You understand (even without writing code yet) that this class alone cannot be built into an object, and you can explain out loud why Attack is left blank here — because Hero and Monster will each need their own version. If you can explain that in your own words, move on.

Class 4 — Hero

OOP Concept: Inheritance (IS-A relationship) + Composition/Aggregation (HAS-A relationship)

Role / Description:
The player's character. Inherits everything general from Character (name, health, attack power), then adds hero-specific stuff: an equipped weapon and a bag of items.

Properties (Fields):

(Inherited automatically: Name, Health, Attack Power — Hero doesn't redefine these, it just gets them for free)
Equipped Weapon — private — one Weapon object
Backpack — private — one Inventory object (see Class 7)

Methods (Actions):

Constructor — takes in: a name (text), starting health (whole number), attack power (whole number), and a starting weapon (one Weapon object) — returns: nothing, it builds a Hero and gives it an empty Inventory automatically
Equip Weapon — takes in: a new weapon (one Weapon object) — returns: nothing, it replaces the current one
Attack (this fills in the blank from Character) — takes in: nothing — returns: a description (text), like "Hero swings [weapon name] for [damage] damage," using the equipped weapon's damage number
Use Item — takes in: an item name (text) — returns: nothing, but it looks up the item in the Backpack and applies its effect (e.g., a potion restores health)

Connections:

Hero IS-A Character (inherits Name, Health, Attack Power, Is Alive, Take Damage)
Hero HAS-A Weapon (composition — the Hero owns and controls it)
Hero HAS-A Inventory (composition — the Hero owns a personal bag of Items)

✅ Done when: You can create one Hero object with a starting weapon, call its Attack method and see a description that correctly uses the weapon's name and damage, and confirm that Hero still has access to Health and Is Alive even though you never wrote those methods inside Hero itself. If inherited methods work without rewriting them, move on.

Class 5 — Monster

OOP Concept: Inheritance (a second class extending the same base)

Role / Description:
The enemy. Just like Hero, it inherits the shared Character foundation — proving that inheritance lets two very different things (a Hero and a Monster) share the same basic skeleton without duplicating code.

Properties (Fields):

(Inherited: Name, Health, Attack Power — same as Hero, for free)
No extra fields needed yet — keep this one lean

Methods (Actions):

Constructor — takes in: a name (text), starting health (whole number), and attack power (whole number) — returns: nothing, it builds a basic Monster
Attack (fills in the blank from Character) — takes in: nothing — returns: a description (text), e.g., "Monster lunges for [attack power] damage"

Connections:

Monster IS-A Character (same inheritance relationship as Hero, but a completely separate branch)

✅ Done when: You can create a plain Monster object, call Attack on it, and see a working description — separately and independently from your Hero object. If Hero and Monster can both exist and both attack, without either one interfering with the other, move on.

Class 6 — Goblin and Dragon

OOP Concept: Polymorphism — Method Overriding & Dynamic Binding (the payoff of everything above)

Role / Description:
Two specific kinds of Monster. This is where the magic happens: both extend Monster, but each overrides Attack with its own personality. When your game code later says "this Character, attack!" — without knowing or caring whether it's a Goblin or a Dragon — the correct version runs automatically. That automatic correctness is dynamic binding.

Goblin — Properties: none extra needed (inherits everything from Monster)
Goblin — Methods:

Attack (overridden) — takes in: nothing — returns: a description (text), something small and quick, like "Goblin stabs for [attack power] damage," possibly a weaker number than the base Monster

Dragon — Properties: none extra needed (inherits everything from Monster)
Dragon — Methods:

Attack (overridden) — takes in: nothing — returns: a description (text), something dramatic, like "Dragon breathes fire for [attack power x 2] damage" — deliberately written to behave differently from Goblin's version

Connections:

Goblin IS-A Monster IS-A Character (a three-level inheritance chain)
Dragon IS-A Monster IS-A Character
The key lesson: if you have a list of "Characters" containing one Goblin and one Dragon, and you tell each one to Attack, each produces its own correct output — even though you never checked which one it was. That's polymorphism in action.

✅ Done when: You can create one Goblin and one Dragon, store them both using the general Character type, call Attack on each through that general type, and see two different, correctly-styled outputs — without your code ever checking "is this a Goblin or a Dragon?" If the correct version runs automatically both times, move on. This is the most important checkpoint in the whole project — don't move on until this genuinely clicks.

Class 7 — Inventory

OOP Concept: Composition/Aggregation (a class whose whole job is to hold other objects)

Role / Description:
A container that holds a changeable collection of Items. This class demonstrates that objects aren't just simple data — they can hold other objects as their core purpose.

Properties (Fields):

Item List — private — a growable list that holds Item objects

Methods (Actions):

Constructor — takes in: nothing — returns: nothing, it builds an empty list, ready to hold items
Add Item — takes in: an item (one Item object) — returns: nothing, it places the item into the list
Remove Item — takes in: an item's name (text) — returns: nothing, it finds and removes the matching Item
Show Contents — takes in: nothing — returns: a readable list (text) of everything currently held
Find Item — takes in: a name (text) — returns: the matching Item object (or nothing, if not found)

Connections:

Inventory is HAS-A'd by Hero (a Hero owns exactly one Inventory)
Inventory HAS-MANY Items (a "part-whole" relationship — if the Hero's Inventory is thrown away, the Items inside go with it, which is the hallmark of composition)

✅ Done when: You can add two or three different Items to one Inventory, print the full contents, remove one by name, and print the contents again to confirm it's gone. If adding and removing both work correctly, move on.

Class 8 — Game Controller

OOP Concept: Bringing it all together — no new concept, just orchestration

Role / Description:
The "referee" of the game. It doesn't inherit from anything and isn't inherited from. Its only job is to create the objects, run the turn loop, and call methods on the Hero and Monster it's holding — without ever needing to know the exact subtype of the Monster it's fighting. That's the practical use of polymorphism.

Properties (Fields):

The current Hero object
The current Monster object (could be a Goblin, a Dragon, or any future subclass — the controller doesn't care)

Methods (Actions):

Start Game — takes in: nothing — returns: nothing, it creates a Hero and picks a random Monster subtype to fight
Run Turn — takes in: nothing — returns: nothing, it carries out one round of combat (see flow below)
Check Game Over — takes in: nothing — returns: true or false, based on whether the Hero or Monster has run out of health
End Game — takes in: nothing — returns: nothing, it prints a win or lose message

Connections:

Controller USES Hero and USES Character (through whichever Monster subtype was created)
This is composition too, technically — but its purpose is coordinating objects, not owning data long-term

✅ Done when: You can run Start Game, then call Run Turn repeatedly, and watch health totals go down correctly on both sides, until Check Game Over correctly reports true and End Game prints the right result. If a full battle plays out start to finish without you manually managing any of the object details yourself, you're finished.

The Game Loop — One Turn of Combat, Step by Step

Here is what actually happens, moment to moment, once you press "Start":

Setup: The Game Controller creates one Hero (with a starting Weapon and empty Inventory) and randomly creates one Monster — either a Goblin or a Dragon, decided at that moment.
Display: The Controller prints both fighters' names and health so the player knows where things stand.
Player's Turn:
The Controller asks the player to choose: Attack, or Use an Item.
If Attack is chosen, the Controller calls the Hero's Attack method. Internally, this reads the Hero's equipped Weapon and calculates damage from it.
That damage is subtracted from the Monster's health, through the Take Damage method the Monster inherited from Character.
Check for Victory: The Controller calls Is Alive on the Monster. If it's no longer alive, print a win message and stop the loop.
Monster's Turn:
The Controller calls Attack on the Monster — but here's the key moment: the Controller's code just says "attack," treating the Monster as a generic Character. It doesn't check "are you a Goblin or a Dragon?"
Dynamic binding takes over silently: if it's a Goblin, the Goblin's version of Attack runs; if it's a Dragon, the Dragon's version runs instead. Same line of Controller code, two completely different results, decided automatically based on the real object underneath.
That damage is subtracted from the Hero's health.
Check for Defeat: The Controller calls Is Alive on the Hero. If it's no longer alive, print a loss message and stop the loop.
Repeat: If both fighters are still alive, go back to Step 2 and run another turn.
Why This Order Works
You start with the smallest possible class (Item) so "object" stops being an abstract word and becomes something you can literally create and print.
Encapsulation comes next (Weapon) while the class is still simple, so private fields and getters/setters don't get lost in complexity.
Abstraction (Character) is introduced right when you have two things (Hero, Monster) that clearly need to share a foundation — so the reason for an abstract class is obvious, not just a rule to memorize.
Inheritance and composition are taught side-by-side in Hero, since real classes almost always use both together.
Polymorphism is saved for last and given its own dedicated pair of classes (Goblin/Dragon), because it's the hardest idea to see until you already have inheritance working — it's the payoff, not the starting point.
The Game Controller closes the loop by showing that all this structure exists to make the actual gameplay code shorter and simpler, not longer.
