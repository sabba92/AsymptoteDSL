size(20cm, 20cm);
draw(circle((21.0,6.0), 1.0), black);
draw(circle((1.0,1.0), 1.0), black);
draw(circle((11.0,8.5), 1.0), black);
draw(circle((1.0,11.0), 1.0), black);
draw(circle((11.0,3.5), 1.0), black);
draw(circle((1.0,6.0), 1.0), black);
fill(shift(16.0, 1.0) * box((-0.25,1.0), (0.25,-1.0)), black);
fill(shift(6.0, 8.5) * box((-0.25,1.0), (0.25,-1.0)), black);
fill(shift(6.0, 3.5) * box((-0.25,1.0), (0.25,-1.0)), black);
fill(shift(16.0, 11.0) * box((-0.25,1.0), (0.25,-1.0)), black);
fill(shift(16.0, 6.0) * box((-0.25,1.0), (0.25,-1.0)), black);
label("P3", (21.0,5.0), align = S, black);
label("P5", (1.0,0.0), align = S, black);
label("P2", (11.0,7.5), align = S, black);
label("P0", (1.0,10.0), align = S, black);
label("P1", (11.0,2.5), align = S, black);
label("P4", (1.0,5.0), align = S, black);
label("T2", (16.0,0.0), align = S, black);
label("T1", (6.0,7.5), align = S, black);
label("T5", (6.0,2.5), align = S, black);
label("T4", (16.0,10.0), align = S, black);
label("T3", (16.0,5.0), align = S, black);
draw((12.0,3.5) -- (15.75,1.0), arrow = Arrow(HookHead), black);
label("5", (13.875,2.25), align = S, black);
draw((2.0,11.0) -- (5.75,8.5), arrow = Arrow(HookHead), black);
label("1", (3.875,9.75), align = S, black);
draw((2.0,11.0) -- (5.75,3.5), arrow = Arrow(HookHead), black);
label("1", (3.875,7.25), align = S, black);
draw((2.0,6.0) -- (5.75,3.5), arrow = Arrow(HookHead), black);
label("1", (3.875,4.75), align = S, black);
draw((2.0,1.0) -- (5.75,3.5), arrow = Arrow(HookHead), black);
label("1", (3.875,2.25), align = S, black);
draw((12.0,8.5) -- (15.75,11.0), arrow = Arrow(HookHead), black);
label("1", (13.875,9.75), align = S, black);
draw((12.0,3.5) -- (15.75,6.0), arrow = Arrow(HookHead), black);
label("1", (13.875,4.75), align = S, black);
draw((12.0,8.5) -- (15.75,6.0), arrow = Arrow(HookHead), black);
label("1", (13.875,7.25), align = S, black);
draw((16.25,1.0) -- (20.0,6.0), arrow = Arrow(HookHead), black);
label("1", (18.125,3.5), align = S, black);
draw((6.25,8.5) -- (10.0,3.5), arrow = Arrow(HookHead), black);
label("1", (8.125,6.0), align = S, black);
draw((6.25,8.5) -- (10.0,8.5), arrow = Arrow(HookHead), black);
label("2", (8.125,8.5), align = S, black);
draw((6.25,3.5) -- (10.0,3.5), arrow = Arrow(HookHead), black);
label("1", (8.125,3.5), align = S, black);
draw((16.25,11.0) -- (20.0,6.0), arrow = Arrow(HookHead), black);
label("1", (18.125,8.5), align = S, black);
draw((16.25,6.0) -- (20.0,6.0), arrow = Arrow(HookHead), black);
label("1", (18.125,6.0), align = S, black);
fill(circle((1.0,11.0), 0.125), black);
fill(circle((11.0,3.5), 0.125), black);
fill(circle((11.333333333333334,3.8333333333333335), 0.125), black);
fill(circle((10.666666666666666,3.1666666666666665), 0.125), black);
label("Created with AsymptoteDSL", (20.0,-1.0), align = NoAlign, black);
