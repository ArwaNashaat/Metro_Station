%first line
connected(new_elmarg,elmarg).
connected(elmarg,ezbet_elnakhl).
connected(ezbet_elnakhl,ain_shams).
connected(ain_shams,elmatareyya).
connected(elmatareyya,helmeyet_elzaitoun).
connected(helmeyet_elzaitoun,hadayeq_elzaitoun).
connected(hadayeq_elzaitoun,saray_elqobba).
connected(saray_elqobba,hammamat_elqobba).
connected(hammamat_elqobba,kobri_elqobba).
connected(kobri_elqobba,manshiet_elsadr).
connected(manshiet_elsadr,eldemerdash).
connected(eldemerdash,ghamra).
connected(ghamra,alshohadaa).
connected(alshohadaa,urabi).
connected(urabi,nasser).
connected(nasser,sadat).
connected(sadat,saad_zaghloul).
connected(saad_zaghloul, alsayyeda_zeinab).
connected(alsayyeda_zeinab,elmalek_elsaleh).
connected(elmalek_elsaleh,margirgis).
connected(margirgis,elzahraa).
connected(elzahraa,dar_elsalam).
connected(dar_elsalam,hadayeq_elmaadi).
connected(hadayeq_elmaadi,maadi).
connected(maadi,thakanat_elmaadi).
connected(thakanat_elmaadi,tora_elbalad).
connected(tora_elbalad,kozzika).
connected(kozzika,tora_elasmant).
connected(tora_elasmant,elmaasara).
connected(elmaasara,hadayeq_helwan).
connected(hadayeq_helwan,wadi_hof).
connected(wadi_hof,helwan_university).
connected(helwan_university,ain_helwan).
connected(ain_helwan,helwan).
%second line
connected(shobra_elkheima,koliet_elzeraa).
connected(koliet_elzeraa,mezallat).
connected(mezallat,khalafawy).
connected(khalafawy,sainte_teresa).
connected(sainte_teresa,road_elfarag).
connected(road_elfarag,massara).
connected(massara,alshohadaa).
connected(alshohadaa,ataba).
connected(ataba,naguib).
connected(naguib,sadat).
connected(sadat,opera).
connected(opera,dokki).
connected(dokki,bohooth).
connected(bohooth,cairo_university).
connected(cairo_university,faisal).
connected(faisal,giza).
connected(giza,omm_elmisryeen).
connected(omm_elmisryeen,sakiat_mekki).
connected(sakiat_mekki,elmounib).
%Task 1:
%Show the full path taken by the metro, from a source station to a destination given by the user with limit number of Stations (can be any number or ‘any’ if you don’t care).

station(any).
path2(Src,Dst,N,[[Src,Dst]]) :- connected(Src,Dst).
path2(Src,Dst,N,[[Src,Z]|P]):- station(N),connected(Src,Z),path2(Z,Dst,N,P);
                                                          integer(N),N1 is N-1,N1>0,connected(Src,Z),path2(Z,Dst,N1,P).

path(Src,Dst,N,[[Src,Z]|P]):-
                                  path2(Src,Dst,N,[[Src,Z]|P]);
                                  path2(Dst,Src,N,[[Dst,Z]|P]).

path(Src,Dst,N):- path(Src,Dst,N,[[Src,Z]|P]),
                                  write('The path from \''),
                                  write(Src),write('\' to \''), write(Dst), write('\' is: '),
                                  writeln([[Src,Z]|P]);

                                  path(Dst,Src,N,[[Dst,Z]|P]),
                                                                  write('The path from \''),
                                  write(Dst),write('\' to \''), write(Src), write('\' is: '),
                                  writeln([[Dst,Z]|P]).




%Task 2
%Count number of stations directly connected to a given station. (Don’t use any built in predicate (findall , bagof … )

inList(Dst,[Dst|_],_):- !,fail.
inList(Dst,[],[Dst]):- !.
inList(Dst,[H|T],[H|L]):- inList(Dst,T,L).

findStations(X,Y):-connected(X,Y);connected(Y,X).

newstation(Src,N,NewList,List):- findStations(Src,Dst), inList(Dst,NewList,L), newstation(Src,N,L,List),countStations(List,N).
newstation(Src,N,NewList,NewList).

nstation(Src):- newstation(Src,N,[],List),write('Numbers of stations = '),write(N),!.





%Task 3
%Help the passengers and tell them the cost of moving from one station to another.


ticket(N,3):- N<7.
ticket(N,5):- N>=7,N=<16.
ticket(N,7):- N>16.

countStations([],0).
countStations([_|L],N):- countStations(L,N1),N is N1+1.

cost(Src,Dst):- path(Src,Dst,any,Stations),
                                         countStations(Stations,N),
                                         ticket(N,Cost), write('Cost = '),write(Cost),writeln(' EGP.').
































